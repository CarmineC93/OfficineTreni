package org.lessons.java.controller;

import javax.validation.Valid;

import org.lessons.java.bean.Utente;
import org.lessons.java.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
	
	@Autowired
    private UtenteService utenteService;
	
	
    @GetMapping("/registrazione")
    public String mostraPaginaRegistrazione(Model model) {
        model.addAttribute("utente", new Utente());
        return "registrazione";
    }
    
    
    @PostMapping("/registrazione")
    public String processaRegistrazione(@Valid @ModelAttribute("utente") Utente utente,BindingResult bindingResult, Model model) throws Exception {
        if (utenteService.findByEmail(utente.getEmail()) == null) {
            
        	if(bindingResult.hasErrors()) {
        		
        		model.addAttribute("errori",bindingResult);
        		model.addAttribute("utente",utente);
        		
        		return "registrazione";
        	}
        	
        	 String passwordInChiaro = utente.getPassword();
        	 BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        	 
        	 String passwordHashed = passwordEncoder.encode(passwordInChiaro);
        	 utente.setPassword(passwordHashed);
        	
//        	 ??
        	utente.setNome(utente.getNome());
            utente.setCognome(utente.getCognome());
        	
            utenteService.registraUtente(utente);
            
            return "redirect:/login";
        } else {
            // Utente già presente, gestisci l'errore
            return "redirect:/registrazione?errore";
        }
    }

}
