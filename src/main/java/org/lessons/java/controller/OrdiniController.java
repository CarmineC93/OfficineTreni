package org.lessons.java.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.lessons.java.bean.Ordine;
import org.lessons.java.bean.Treno;
import org.lessons.java.bean.Utente;
import org.lessons.java.bean.Vagone;
import org.lessons.java.service.OrdineService;
import org.lessons.java.service.TrenoService;
import org.lessons.java.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ordine")
public class OrdiniController {

	@Autowired
    private OrdineService ordineService;
	@Autowired
	private TrenoService trenoService;
	@Autowired
    private UtenteService utenteService;
	
//INDEX 
	
	@GetMapping("/index")
	public String index(Model model, HttpSession session) {
		
		Utente utente = (Utente) session.getAttribute("utente");
		if (utente == null) {
			return "redirect:/login";
		}
		
		
		List<Ordine> ordini;

	    if ("admin".equals(utente.getRuolo())) {
	        ordini = ordineService.findAll();
	    } else {
	        ordini = ordineService.findAllByUserId(utente.getId());
	    }
		
	    // Sort orders by descending date
	    ordini.sort(Comparator.comparing(Ordine::getData).reversed());
		
		model.addAttribute("listaOrdini", ordini);
				
		return "ordiniIndex";
	}
	

//CREATE
	@PostMapping("/aggiungi-ordine")
	public String aggiungiOrdine(@RequestParam("idTreno") int idTreno, @RequestParam("idUtente") int idUtente ){
		
		Utente utente = utenteService.find(idUtente);
	    Treno treno = trenoService.find(idTreno);

        LocalDateTime oggi = LocalDateTime.now();
       

        
	    double costoTotale = treno.getVagone().stream()
                .mapToDouble(Vagone::getCosto)
                .sum();
		
	    Ordine nuovoOrdine = new Ordine("In valutazione", utente, treno, oggi, costoTotale);
 
	    
	    ordineService.crea(nuovoOrdine);
	    
	    return "redirect:/ordine/index";
	    }
	
//UPDATE
	
    @PostMapping("/update-status")
    public String updateStatus(@RequestParam("orderId") int orderId, @RequestParam("newStatus") String newStatus, HttpSession session) {
       
    	Utente utente = (Utente) session.getAttribute("utente");
        if (utente == null) {
            return "redirect:/login"; // L'utente non è autenticato
        }
    	
        if ("admin".equals(utente.getRuolo())) {

    	
    	// Fetch the order from the database using orderId
        Ordine order = ordineService.find(orderId);
        
        // Update the status
        order.setStato(newStatus);
        
        // Save the updated order
        ordineService.update(order);
        
        return "redirect:/ordine/index";
        }
        else {
           //creare una pagina di errore "accesso negato"
        	return "redirect:/ordine/index";
        }
    }
	
	
	
	
	
	
	
	
}
