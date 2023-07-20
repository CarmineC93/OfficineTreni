package org.lessons.java.controller;

import java.util.List;

import org.lessons.java.pojo.Treno;
import org.lessons.java.service.TrenoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrenoController {

	TrenoService trenoService = new TrenoService();
	
	
	@GetMapping("/treno")
	public String index(Model model) {
		
		List<Treno> treni = trenoService.findAllTreni();
		
		model.addAttribute("treni",treni);
		
		return "trenoIndex";
	}
	
	
	
	
}
