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
import org.lessons.java.service.BuilderTrain;
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

	/*TrenoService trenoService = new TrenoService();
	UtenteService utenteService = new UtenteService();
	VagoneService vagoneService = new VagoneService();*/
	
    @Autowired
    private VagoneService vagoneService;
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private TrenoService trenoService;
	
	@Autowired
    private BuilderTrain builder;
	
	@GetMapping("/index")
	public String index(Model model,HttpSession session) {
		
		  Utente utente = (Utente) session.getAttribute("utente");
	        if (utente == null) {
	            return "redirect:/login";
	        }
		
		List<Treno> treni = trenoService.findAll();
		
		for (Treno treno : treni) {
		    for (Vagone vagone : treno.getVagone()) {
		        byte[] imgBytes = vagone.getImgBytes();
		        if (imgBytes != null) {
		            String base64Image = Base64.getEncoder().encodeToString(imgBytes);
		            vagone.setBase64Image(base64Image);
		        } else {
		            vagone.setBase64Image(null); // Imposta base64Image a null se l'immagine è assente o vuota
		        }
		    }
		}
		
		model.addAttribute("listaTreni",treni);
		

		return "trenoIndex";
	}
	
	

	@GetMapping("/show/{id}")
	public String show(
			@PathVariable("id") int id, HttpSession session, Model model) 
	{
		  Utente utente = (Utente) session.getAttribute("utente");
	        if (utente == null) {
	            return "redirect:/login";
	        }
		
		Treno treno = trenoService.find(id);
		    for (Vagone vagone : treno.getVagone()) {
		        byte[] imgBytes = vagone.getImgBytes();
		        if (imgBytes != null) {
		            String base64Image = Base64.getEncoder().encodeToString(imgBytes);
		            vagone.setBase64Image(base64Image);
		        } else {
		            vagone.setBase64Image(null); // Imposta base64Image a null se l'immagine è assente o vuota
		        }
		    }
		    
		    
		model.addAttribute("treno", treno);
		
		model.addAttribute("vagoni", treno.getVagone());
		
		return "trenoShow";
	}
	
	
	
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

	        byte[] imageBytes = vagone.getImgBytes();
	        if (imageBytes != null) {
	            // Converti l'array di byte in una stringa Base64
	            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
	            // Salva la stringa Base64 nel model del singolo vagone
	            vagone.setBase64Image(base64Image);
	        }
	        
	        // Convert tipologia to a String using a utility method and store it in the map
	        String tipologiaString = convertTipologiaToString(tipologia);
	        tipologiaMap.put(tipologia, tipologiaString);
	    }
	    
	    // Add the tipologiaMap to the model
	    model.addAttribute("tipologiaMap", tipologiaMap);
 
		
		return "formCreaTreno";
	}
	

	@PostMapping("/crea")
	public String creaTreno(@ModelAttribute Treno treno, @RequestParam(name = "selezioneVagone", required = false) List<Integer> selezioneVagone, Model model, HttpSession session) {
		  Utente utente = (Utente) session.getAttribute("utente");
	        if (utente == null) {
	            return "redirect:/login";
	        }
		
	        builder.removeAll();
		 if (selezioneVagone == null || selezioneVagone.isEmpty()) {
	           
	            return "formCreaTreno";
	        }
		

	    // creo stringa sui vagoni selezionati dall'utente
//        StringBuilder composedString = new StringBuilder();
//        if (selezioneVagone != null) {
//            for (Integer vagoneId : selezioneVagone) {
//                Vagone vagone = vagoneService.find(vagoneId);
//                if (vagone != null) {
//                    // compongo la stringa
//                    composedString.append(vagone.getTipologia());
//                }
//            }
//        }
		 
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
		        
		        
    	        byte[] imageBytes = vagone.getImgBytes();
    	        if (imageBytes != null) {
    	            // Converti l'array di byte in una stringa Base64
    	            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
    	            // Salva la stringa Base64 nel model del singolo vagone
    	            vagone.setBase64Image(base64Image);
    	        }
		        
		    }
	   
	        // Costruisci la composizione del treno utilizzando il metodo aggiungiVagone
	        for (Vagone vagone : vagoniSelezionati) {

	            try {
	          
	            	builder.aggiungiVagone(vagone);
	            	            	
	            } catch (LocomotiveNotFoundException e) {
					System.out.println("Error: " + e.getMessage());
					model.addAttribute("errore",e.getMessage());
				    model.addAttribute("treno", treno);
				    model.addAttribute("listaVagoni", listaVagoni);
				    model.addAttribute("vagoniSelezionati", vagoniSelezionati);
				    model.addAttribute("tipologiaMap", tipologiaMap);
				    model.addAttribute("selezioneVagone",selezioneVagone);
				    
				    builder.removeAll();
					return "formCreaTreno";
					 
				} catch (IncompatibleWagonTypologyException e) {
					System.out.println("Error: " + e.getMessage());
					model.addAttribute("errore",e.getMessage());
					model.addAttribute("treno",treno);
					model.addAttribute("listaVagoni",listaVagoni);
				    model.addAttribute("tipologiaMap", tipologiaMap);
	                model.addAttribute("vagoniSelezionati", vagoniSelezionati);
	                model.addAttribute("selezioneVagone",selezioneVagone);
	                builder.removeAll();
					 return "formCreaTreno";
					 
				} catch (MaxWeightReachedException e) {
					System.out.println("Error: " + e.getMessage());
					model.addAttribute("errore",e.getMessage());
					model.addAttribute("treno",treno);
				    model.addAttribute("tipologiaMap", tipologiaMap);
					model.addAttribute("listaVagoni",listaVagoni);
	                model.addAttribute("vagoniSelezionati", vagoniSelezionati);
	                model.addAttribute("selezioneVagone",selezioneVagone);
	                builder.removeAll();
					return "formCreaTreno";
					 
				} catch (RestaurantAlreadyPresentException e) {
					System.out.println("Error: " + e.getMessage());
					model.addAttribute("errore",e.getMessage());
					model.addAttribute("treno",treno);
				    model.addAttribute("tipologiaMap", tipologiaMap);
					model.addAttribute("listaVagoni",listaVagoni);
	                model.addAttribute("vagoniSelezionati", vagoniSelezionati);
	                builder.removeAll();
	                return "formCreaTreno";
					
				} catch (TrainAlreadyCompletedException e) {
					System.out.println("Error: " + e.getMessage());
					model.addAttribute("errore",e.getMessage());
					model.addAttribute("treno",treno);
				    model.addAttribute("tipologiaMap", tipologiaMap);
					model.addAttribute("listaVagoni",listaVagoni);
	                model.addAttribute("vagoniSelezionati", vagoniSelezionati);
	                model.addAttribute("selezioneVagone",selezioneVagone);
	                builder.removeAll();
					return "formCreaTreno";
					 
				} catch (WagonNeededException e) {
					model.addAttribute("errore",e.getMessage());
					model.addAttribute("treno",treno);
				    model.addAttribute("tipologiaMap", tipologiaMap);
					model.addAttribute("listaVagoni",listaVagoni);	                
					model.addAttribute("vagoniSelezionati", vagoniSelezionati);
					model.addAttribute("selezioneVagone",selezioneVagone);
					builder.removeAll();
					
					 return "formCreaTreno";
				} catch (RestaurantNotBeetwenPassengersException e) {
					System.out.println("Error: " + e.getMessage());
					model.addAttribute("errore",e.getMessage());
					model.addAttribute("treno",treno);
				    model.addAttribute("tipologiaMap", tipologiaMap);
					model.addAttribute("listaVagoni",listaVagoni);
	                model.addAttribute("vagoniSelezionati", vagoniSelezionati);
	                model.addAttribute("selezioneVagone",selezioneVagone);
	                builder.removeAll();
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
