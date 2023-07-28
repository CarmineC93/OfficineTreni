/*package org.lessons.java.controller;

import java.util.List;

import org.lessons.java.bean.Treno;
<<<<<<< Updated upstream
import org.lessons.java.bilderConcreto.GenericBilder;
import org.lessons.java.eccezzioni.TrenoException;
=======
import org.lessons.java.bean.Utente;
import org.lessons.java.bean.Vagone;
import org.lessons.java.eccezioni.IncompatibleWagonTypologyException;
import org.lessons.java.eccezioni.LocomotiveNotFoundException;
import org.lessons.java.eccezioni.MaxWeightReachedException;
import org.lessons.java.eccezioni.RestaurantAlreadyPresentException;
import org.lessons.java.eccezioni.TrainAlreadyCompletedException;
import org.lessons.java.eccezioni.WagonNeededException;
import org.lessons.java.service.BuilderTrain;
>>>>>>> Stashed changes
import org.lessons.java.service.TrenoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/treno")
public class TrenoController {

	TrenoService trenoService = new TrenoService();

	
	@GetMapping("/index")
	public String index(Model model) {
		

		
		List<Treno> treni = trenoService.findAll();
		
		model.addAttribute("listaTreni",treni);
		
		return "trenoIndex";
	}
	
	@GetMapping("/formCrea")
	public String Crea() {
		
		System.out.println("form crea");
		
<<<<<<< Updated upstream
		
=======
		List<Vagone> listaVagoni = vagoneService.findAll();
		String compagniaSelezionata = "Nullo";
		
		model.addAttribute("listaVagoni", listaVagoni);
		model.addAttribute("compagniaSelezionata", compagniaSelezionata);
>>>>>>> Stashed changes
		
		return "formCreaTreno";
	}
	
<<<<<<< Updated upstream
=======

	@PostMapping("/crea")
	public String creaTreno(@ModelAttribute Treno treno, @RequestParam(name = "selezioneVagone", required = false) List<Integer> selezioneVagone,  @RequestParam(name = "compagnia", required = true) String compagnia, Model model, HttpSession session) {

		
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

	        // Recupera i vagoni corrispondenti agli ID selezionati
	        List<Vagone> vagoniSelezionati = selezioneVagone.stream()
	                .map(vagoneService::find)
	                .collect(Collectors.toList());

	        List<Vagone> listaVagoni = vagoneService.findAllByCompany(compagnia);
	       
	        // Costruisci la composizione del treno utilizzando il metodo aggiungiVagone
	        for (Vagone vagone : vagoniSelezionati) {
	            try {
	            	
	            	builder.aggiungiVagone(vagone);
	            	
	            } catch (LocomotiveNotFoundException e) {
					System.out.println("Error: " + e.getMessage());
					model.addAttribute("errore",e.getMessage());
					model.addAttribute("listaVagoni",listaVagoni);
					model.addAttribute("treno",treno);
					 return "formCreaTreno";
				} catch (TrainAlreadyCompletedException e) {
					System.out.println("Error: " + e.getMessage());
					model.addAttribute("errore",e.getMessage());
					model.addAttribute("listaVagoni",listaVagoni);
					model.addAttribute("treno",treno);
					 return "formCreaTreno";
				} catch (IncompatibleWagonTypologyException e) {
					System.out.println("Error: " + e.getMessage());
					model.addAttribute("errore",e.getMessage());
					model.addAttribute("listaVagoni",listaVagoni);
					model.addAttribute("treno",treno);
					 return "formCreaTreno";
				} catch (MaxWeightReachedException e) {
					System.out.println("Error: " + e.getMessage());
					model.addAttribute("errore",e.getMessage());
					model.addAttribute("listaVagoni",listaVagoni);
					model.addAttribute("treno",treno);
					 return "formCreaTreno";
				} catch (RestaurantAlreadyPresentException e) {
					System.out.println("Error: " + e.getMessage());
					model.addAttribute("errore",e.getMessage());
					model.addAttribute("listaVagoni",listaVagoni);
					model.addAttribute("treno",treno);
					return "formCreaTreno";
				} catch (WagonNeededException e) {
					// TODO: handle exception
					model.addAttribute("errore",e.getMessage());
					model.addAttribute("listaVagoni",listaVagoni);
					model.addAttribute("treno",treno);
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
			
			Utente utente = utenteService.find(idUtente);
			
			treno.setUtente(utente);
	        
	        // Salva il nuovo treno
	        trenoService.crea(treno);

	        // Effettua il reindirizzamento a una pagina di successo o a un'altra view.
	        return "redirect:/treno/index";
	    
}
>>>>>>> Stashed changes
	
	@GetMapping("/crea")
	public String creaTreno(@RequestParam String sigla,Model model) {
		
		System.out.println("sigla = " + sigla);
		
		GenericBilder italoBilder = new GenericBilder();
		
		org.lessons.java.treno.Treno trenoItalo = null;
		
		try {			
			trenoItalo = italoBilder.costruisciTreno(sigla);
		} catch (TrenoException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		model.addAttribute("message","abbiamo creato il treno con questa sigla");
		model.addAttribute("treno",trenoItalo);
	
		
		return "viewTreno";
	}
	
	
}*/
