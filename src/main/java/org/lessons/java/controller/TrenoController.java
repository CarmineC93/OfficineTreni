package org.lessons.java.controller;

import java.util.List;

import org.lessons.java.bean.Treno;
import org.lessons.java.bean.Utente;
import org.lessons.java.service.TrenoService;
import org.lessons.java.service.UtenteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/treno")
public class TrenoController {

	TrenoService trenoService = new TrenoService();
	UtenteService utenteService = new UtenteService();

	
	@GetMapping("/index")
	public String index(Model model) {
		

		
		List<Treno> treni = trenoService.findAll();
		
		model.addAttribute("listaTreni",treni);
		
		return "trenoIndex";
	}
	
	@GetMapping("/formCrea")
	public String Crea() {
		
		System.out.println("form crea");
		
		
		
		return "formCreaTreno";
	}
	
	
	@PostMapping("/crea")
	public String creaTreno(@ModelAttribute Treno treno,Model model) {
		
//		System.out.println("sigla = " + sigla);
		
//		GenericBilder italoBilder = new GenericBilder();
		
//		org.lessons.java.treno.Treno trenoItalo = null;
		
//		try {			
//			trenoItalo = italoBilder.costruisciTreno(sigla);
//		} catch (TrenoException e) {
//			// TODO: handle exception
//			System.out.println(e.getMessage());
//		}
		
//		model.addAttribute("message","abbiamo creato il treno con questa sigla");
//		model.addAttribute("treno",treno);
	
		Utente utente = utenteService.find(2);
		
		treno.setUtente(utente);
		
		trenoService.crea(treno);
		
		return "redirect:/treno/index";
	}
	
	
	
}
