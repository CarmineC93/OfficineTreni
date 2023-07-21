package org.lessons.java.controller;

import java.util.List;

import org.lessons.java.bean.Treno;
import org.lessons.java.bilderConcreto.GenericBilder;
import org.lessons.java.eccezzioni.TrenoException;
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
		
		
		
		return "formCreaTreno";
	}
	
	
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
	
	
}
