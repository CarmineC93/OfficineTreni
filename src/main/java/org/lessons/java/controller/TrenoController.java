package org.lessons.java.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.lessons.java.bean.Treno;
import org.lessons.java.bean.Utente;
import org.lessons.java.bean.Vagone;
import org.lessons.java.bilderConcreto.GenericBilder;
import org.lessons.java.eccezzioni.TrenoException;
import org.lessons.java.service.TrenoService;
import org.lessons.java.service.UtenteService;
import org.lessons.java.service.VagoneService;
import org.springframework.context.support.LiveBeansView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/treno")
public class TrenoController {

	TrenoService trenoService = new TrenoService();
	UtenteService utenteService = new UtenteService();
	VagoneService vagoneService = new VagoneService();
	

	
	@GetMapping("/index")
	public String index(Model model) {
		

		
		List<Treno> treni = trenoService.findAll();
		
		model.addAttribute("listaTreni",treni);
		
		return "trenoIndex";
	}
	
	@GetMapping("/formCrea")
	public String Crea(Model model) {
		
		
		List<Vagone> listaVagoni = vagoneService.findAll();
		
		model.addAttribute("listaVagoni",listaVagoni);
		
		return "formCreaTreno";
	}
	
	
	@PostMapping("/crea")
	public String creaTreno(@ModelAttribute Treno treno,Model model,HttpSession session) {
		
		List<Vagone> listaVagoni = treno.getVagone();
		String sigla = "";
		
		for(Vagone a : listaVagoni) {
			
			sigla += a.getTipologia();
			
		}
		treno.setSigla(sigla);
		
		System.out.println(listaVagoni);
		System.out.println(sigla);
		
		GenericBilder italoBilder = new GenericBilder();
		
		org.lessons.java.treno.Treno trenoItalo = null;
		
		try {			
			trenoItalo = italoBilder.costruisciTreno(treno.getSigla());
		} catch (TrenoException e) {
			// TODO: handle exception
			
			model.addAttribute("errore", e.getMessage());
			model.addAttribute("treno",treno);
			
			return "formCreaTreno";
		}
		
		
		
		
		
		 int idUtente = (int) session.getAttribute("userId");
		
		Utente utente = utenteService.find(idUtente);
		
		treno.setUtente(utente);
		
		trenoService.crea(treno);
		
		
		return "redirect:/treno/index";
	}
	
	
	
	@GetMapping("/show/{id}")
	public String show(
			Model model,
			@PathVariable("id") int id
			
	) {
		
		Treno treno = trenoService.find(id);
	
		model.addAttribute("treno", treno);
		
		
		
		model.addAttribute("vagoni",treno.getVagone());
		

		
		
		return "trenoShow";
	}

	
	

	
	
}
