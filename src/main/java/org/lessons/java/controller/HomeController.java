package org.lessons.java.controller;

import javax.servlet.http.HttpSession;

import org.lessons.java.bean.Utente;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {


	@GetMapping("/home")
    public String home(HttpSession session) {
        Utente utente = (Utente) session.getAttribute("utente");
        if (utente != null) {
            session.setAttribute("utente", utente);
        }
        return "home";
	}
	
	
    @GetMapping("/chisiamo")
        public String chisiamo(HttpSession session) {

        Utente utente = (Utente) session.getAttribute("utente");
        if (utente != null) {
            session.setAttribute("utente", utente);
        }
         return "chisiamo"; 
    }
    
  
}
