package org.lessons.java.controller;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.lessons.java.bean.Treno;
import org.lessons.java.bean.Utente;
import org.lessons.java.bean.Vagone;
import org.lessons.java.eccezioni.IncompatibleWagonTypologyException;
import org.lessons.java.eccezioni.LocomotiveNotFoundException;
import org.lessons.java.eccezioni.MaxWeightReachedException;
import org.lessons.java.eccezioni.RestaurantAlreadyPresentException;
import org.lessons.java.eccezioni.RestaurantNotBeetwenPassengersException;
import org.lessons.java.eccezioni.TrainAlreadyCompletedException;
import org.lessons.java.eccezioni.WagonNeededException;
import org.lessons.java.service.TrenoBuilder;
import org.lessons.java.service.TrenoService;
import org.lessons.java.service.UtenteService;
import org.lessons.java.service.VagoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/treno")
public class TrenoController {

    @Autowired
    private VagoneService vagoneService;
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private TrenoService trenoService;
	@Autowired
    private TrenoBuilder trenoBuilder;
	
//SHOW
	//SHOW LISTA DI TRENI
	@GetMapping("/index")
	public String index(Model model, HttpSession session) {
		
		  Utente utente = (Utente) session.getAttribute("utente");
	        if (utente == null) {
	            return "redirect:/login";
	        }
		
		List<Treno> treni = trenoService.findAll();
		
        // Trova i valori più bassi e più alti di pesoTotale tra i risultati della ricerca
        double minPesoTotale = treni.stream().mapToDouble(Treno::getPesoTotale).min().orElse(0);
        double maxPesoTotale = treni.stream().mapToDouble(Treno::getPesoTotale).max().orElse(1000); 
        session.setAttribute("maxPesoTotale", maxPesoTotale);
        model.addAttribute("minPesoTotale", minPesoTotale);
        model.addAttribute("maxPesoTotale", maxPesoTotale);
        
        
        double minLunghezzaTotale = treni.stream().mapToDouble(Treno::getLunghezzaTotale).min().orElse(0);
        double maxLunghezzaTotale = treni.stream().mapToDouble(Treno::getLunghezzaTotale).max().orElse(1000); 
        session.setAttribute("maxLunghezzaTotale", maxLunghezzaTotale);
        model.addAttribute("minLunghezzaTotale", minLunghezzaTotale);
        model.addAttribute("maxLunghezzaTotale", maxLunghezzaTotale);
  
        double minPrezzoTotale = treni.stream().mapToDouble(Treno::getPrezzoTotale).min().orElse(0);
        double maxPrezzoTotale = treni.stream().mapToDouble(Treno::getPrezzoTotale).max().orElse(1000); 
        session.setAttribute("maxPrezzoTotale", maxPrezzoTotale);
        model.addAttribute("minPrezzoTotale", minPrezzoTotale);
        model.addAttribute("maxPrezzoTotale", maxPrezzoTotale);
        
        
		for (Treno treno : treni) {
		    for (Vagone vagone : treno.getVagone()) {
		        //convert immagini in base64
		        convertImgInBase64(vagone);
		    }
		}
		
		model.addAttribute("listaTreni",treni);
		
		return "trenoIndex";
	}
	
	//SHOW TRENO SPECIFICO
	@GetMapping("/show/{id}")
	public String show(@PathVariable("id") int id, HttpSession session, Model model) {
		  Utente utente = (Utente) session.getAttribute("utente");
	        if (utente == null) {
	            return "redirect:/login";
	        }
		
		Treno treno = trenoService.find(id);
		    for (Vagone vagone : treno.getVagone()) {
		        //convert immagini in base64
		        convertImgInBase64(vagone);
		    }
		    
		    
		model.addAttribute("treno", treno);
		
		model.addAttribute("vagoni", treno.getVagone());
		
	   //map per la tipologia che non è lavorabile come char in jsp ma solo con String
	    Map<Character, String> tipologiaMap = new HashMap<>();
	    for (Vagone vagone : treno.getVagone()) {
	        // Get the tipologia from your service or any other method
	        char tipologia = vagone.getTipologia();

	        // Convert tipologia to a String using a utility method and store it in the map
	        String tipologiaString = convertTipologiaToString(tipologia);
	        tipologiaMap.put(tipologia, tipologiaString);
	    }
	    // Add the tipologiaMap to the model
	    model.addAttribute("tipologiaMap", tipologiaMap); 
		
		return "trenoShow";
	}
	
	
//CREATE	
	//ACCESSO A FORM DI CREAZIONE
	@GetMapping("/formCrea")
	public String Crea(Model model, HttpSession session) {
		  Utente utente = (Utente) session.getAttribute("utente");
	        if (utente == null) {
	            return "redirect:/login";
	        }
		model.addAttribute("utente",utente);
		
		List<Vagone> listaVagoni = vagoneService.findAll();
		String compagniaSelezionata = "Nullo";

		model.addAttribute("listaVagoni", listaVagoni);
		model.addAttribute("compagniaSelezionata", compagniaSelezionata);
		
		//map per la tipologia che non è lavorabile come char in jsp ma solo con String
	    Map<Character, String> tipologiaMap = new HashMap<>();
	    for (Vagone vagone : listaVagoni) {
	        // Get the tipologia from your service or any other method
	        char tipologia = vagone.getTipologia();
	        
	        // Convert tipologia to a String using a utility method and store it in the map
	        String tipologiaString = convertTipologiaToString(tipologia);
	        tipologiaMap.put(tipologia, tipologiaString);
	        
	        //convert immagini in base64
	        convertImgInBase64(vagone);
	    }
	    
	    // Add the tipologiaMap to the model
	    model.addAttribute("tipologiaMap", tipologiaMap);
 
		
		return "formCreaTreno";
	}
	
	//CREAZIONE SINGOLO TRENO
	@PostMapping("/crea")
	public String creaTreno(@ModelAttribute Treno treno, @RequestParam(name = "selezioneVagone", required = false) List<Integer> selezioneVagone, Model model, HttpSession session) {
		  Utente utente = (Utente) session.getAttribute("utente");
	        if (utente == null) {
	            return "redirect:/login";
	        }
		
	        trenoBuilder.removeAll();	        
	        
		 if (selezioneVagone == null || selezioneVagone.isEmpty()) {
	            return "formCreaTreno";
	        }
		
	 
		    Map<Character, String> tipologiaMap = new HashMap<>();

		 
	        // Recupera i vagoni corrispondenti agli ID selezionati
	        List<Vagone> vagoniSelezionati = selezioneVagone.stream()
	                .map(vagoneService::find)
	                .collect(Collectors.toList());

	        List<Vagone> listaVagoni = vagoneService.findAll();
	       
		    for (Vagone vagone : listaVagoni) {
		        // Get the tipologia from your service or any other method
		        char tipologia = vagone.getTipologia();
		        // Convert tipologia to a String using a utility method and store it in the map
		        String tipologiaString = convertTipologiaToString(tipologia);
		        tipologiaMap.put(tipologia, tipologiaString);
		        
		        //convert immagini in base64
		        convertImgInBase64(vagone);
		        
		    }
	   
	        // Costruisci la composizione del treno utilizzando il metodo aggiungiVagone
	        for (Vagone vagone : vagoniSelezionati) {

	            try {
	            	trenoBuilder.aggiungiVagone(vagone);
	            	            	
	            } catch (LocomotiveNotFoundException | IncompatibleWagonTypologyException| MaxWeightReachedException |
	                    RestaurantAlreadyPresentException | TrainAlreadyCompletedException | WagonNeededException |
	                    RestaurantNotBeetwenPassengersException e) {
					System.out.println("Error: " + e.getMessage());
					model.addAttribute("errore",e.getMessage());
				    model.addAttribute("treno", treno);
				    model.addAttribute("listaVagoni", listaVagoni);
				    model.addAttribute("vagoniSelezionati", vagoniSelezionati);
				    model.addAttribute("tipologiaMap", tipologiaMap);
				    model.addAttribute("selezioneVagone",selezioneVagone);
				    
				    trenoBuilder.removeAll();
				    
					return "formCreaTreno";
	            }	             	
	            	
	        }
	        
	        
	        treno.setVagone(vagoniSelezionati);
	       
	        // Imposta la sigla del treno utilizzando il campo 'sigla' del treno stesso
	        StringBuilder siglaTreno = new StringBuilder();
	        for (Vagone vagone : treno.getVagone()) {
	            siglaTreno.append(vagone.getTipologia());
	        }
	        
	        treno.setSigla(siglaTreno.toString());
	        
			int idUtente = (int) session.getAttribute("userId");
			
			Utente utenteId = utenteService.find(idUtente);
			
			treno.setUtente(utenteId);

	        // Salva il nuovo treno
	        trenoService.crea(treno);
	
	        // Effettua il reindirizzamento a una pagina di successo o a un'altra view.
	        return "redirect:/treno/index";    
}
	
	 
//RESEARCH
	    @GetMapping("/ricerca")
	    public String ricercaTreni(
	    	@RequestParam(name = "nome", required = false) String nome,
	        @RequestParam(name = "compagnia", required = false) String compagnia,
	        @RequestParam(name = "creatore", required = false) String creatore,
	        @RequestParam(name = "pesoTotale", required = false) Integer pesoTotale,
	        @RequestParam(name = "lunghezzaTotale", required = false) Double lunghezzaTotale,
	        @RequestParam(name = "prezzoTotale", required = false) Double prezzoTotale,
	        @RequestParam(name = "ordData", required = false) String ordData,

	        HttpSession session,
	        Model model) {
	    	
	        Utente utente = (Utente) (session.getAttribute("utente"));
	        if (utente == null) {
	            return "redirect:/login";
	        }
	    	
	        // esegue ricerca utilizzando Criteria
	        List<Treno> risultatiRicerca = trenoService.ricercaTreniAvanzata(nome, compagnia, creatore, pesoTotale,lunghezzaTotale, prezzoTotale, ordData);
	        
	        // converte immagini in Base64	        
	        for (Treno treno : risultatiRicerca) {
	        	for (Vagone vagone : treno.getVagone()) {
	        		convertImgInBase64(vagone);
	        	}
	        }

	        
	        // Aggiunge i risultati al model per visualizzarli nella vista
	        model.addAttribute("risultatiRicerca", risultatiRicerca);

	        return "trenoIndex";
	    }
	   
	    
//FUNZIONI AUSILIARIE	    
	    //Funzione  per convertire l'immagine in Base64
	    private void convertImgInBase64(Vagone vagone) {
	        byte[] imgBytes = vagone.getImgBytes();
	        if (imgBytes != null) {
	            // Converti l'array di byte in una stringa Base64
	            String base64Image = Base64.getEncoder().encodeToString(imgBytes);
	            // Salva la stringa Base64 nel model del singolo vagone
	            vagone.setBase64Image(base64Image);
	        } else {
	            vagone.setBase64Image(null); // Imposta base64Image a null se l'immagine è assente o vuota
	        }
	    }
	    
	    //Funzione per convertire char in String
		 private String convertTipologiaToString(char tipologia) {
		        switch (tipologia) {
		            case 'H':
		                return "Locomotiva";
		            case 'P':
		                return "Passeggeri";
		            case 'R':
		                return "Ristorante";
		            case 'C':
		                return "Cargo";
		            default:
		                return "Tipo non riconosciuto";
		        }
		    }


}
