package org.lessons.java.controller;

import org.lessons.java.bean.Utente;
import org.lessons.java.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String processaRegistrazione(@ModelAttribute("utente") Utente utente) throws Exception {
        if (utenteService.findByEmail(utente.getEmail()) == null) {
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
