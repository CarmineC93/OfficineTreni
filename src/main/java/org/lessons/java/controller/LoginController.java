package org.lessons.java.controller;

import org.lessons.java.bean.Utente;
import org.lessons.java.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	int contatore = 0;

    @Autowired
    private UtenteService utenteService;

    @GetMapping("/login")
    public String mostraPaginaLogin() {
        return "login";
    }
    
    @PostMapping("/login")
    public String processaLogin(@RequestParam("username") String username, 
                                @RequestParam("password") String password,
                                HttpSession session) {
        if (utenteService.verificaCredenziali(username, password)) {
        	
            Utente utente = utenteService.findByEmail(username);
            session.setAttribute("utente", utente);
            
            
            //conteggio utenti connessi
            
            contatore = contatore + 1;
            
            session.getServletContext().setAttribute("contatore", contatore);
          
            System.out.println(contatore);
            
            //disconnessione automatica
            
//             session.setMaxInactiveInterval(10);       

            return "redirect:home";

        } else {
            // Credenziali non valide, gestisci l'errore
            return "redirect:/login?errore";
        }
    }

    
    
    
	    @GetMapping("/logout")
	    public String logout(HttpSession session) {

	    	//decremento contatore
	
	        contatore--;
            session.getServletContext().setAttribute("contatore", contatore);

            System.out.println(contatore);
	        
	        session.invalidate();
	        return "redirect:/login";
	      
	    }

	    

}

