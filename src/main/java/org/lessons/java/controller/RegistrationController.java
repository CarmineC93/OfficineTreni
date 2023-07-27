package org.lessons.java.controller;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.management.relation.Role;
import javax.validation.Valid;

import org.hibernate.Hibernate;
import org.lessons.java.bean.Ruolo;
import org.lessons.java.bean.Utente;
import org.lessons.java.service.RuoloService;
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
	
	@Autowired
	private RuoloService ruoloService;
	
	
	
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
//        	utente.setNome(utente.getNome());
//            utente.setCognome(utente.getCognome());
//            
            Ruolo ruoloUser = ruoloService.find(0);
//            utenteService.registraUtente(utente);
//            ruoloUser.setUtente(utente);
            
        	 utenteService.registraUtente(utente);
//        	 Hibernate.initialize(utente.getRuolo());
//            
//        	 Ruolo ruoloUser = ruoloService.find(0);
//        	 ruoloUser.getUtente().add(utente);
//           
//        	 ruoloService.update(ruoloUser);
//            utente.setRuolo(ruoloUser);
            
            
//         Ruolo userRole = ruoloService.find(0); 
         // Sostituisci "ruoloService" con il tuo servizio per i ruoli 
         // Assegnare il ruolo "user" all'utente 
         
//         utenteService.registraUtente(utente);
           
            
            
            return "redirect:/login";
        } else {
            // Utente già presente, gestisci l'errore
        	
        	model.addAttribute("errori","email gia in uso");
        	
            return "registrazione";
        }
    }
    
    
   

}
