package org.lessons.java.controller;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.lessons.java.bean.Vagone;
import org.lessons.java.service.VagoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class VagoneController {

	    @Autowired
	    private VagoneService vagoneService;
	    
//CREATE	    
	    // Metodo per la visualizzazione del form di creazione del vagone
	    @GetMapping("/crea-vagone")
	    public String showCreateVagoneForm(Model model) {
	        model.addAttribute("vagone", new Vagone());
	        return "/admin/formCreaVagone"; 
	    }

	    
	    // Metodo per gestire il submit del form di creazione del vagone
	    @PostMapping("/salvaVagone")
	    public String saveVagone(@Valid @ModelAttribute("vagone") Vagone vagone, BindingResult bindingResult, Model model) {
	    	// Ottieni l'immagine come MultipartFile
	        MultipartFile file = vagone.getImg();        
	        // Controlla se l'utente ha caricato effettivamente un'immagine
	        if (file != null && !file.isEmpty()) {
	            try {
	                // Converte l'immagine in un array di byte
	                byte[] imageBytes = file.getBytes();
	                // Salva l'array di byte nel campo img del vagone
	                vagone.setImgBytes(imageBytes);
	            } catch (IOException e) {
	                e.printStackTrace();
	                model.addAttribute("errore", "Errore durante il caricamento dell'immagine");
	                return "/admin/formCreaVagone";
	            }
	        } else {
	            // L'utente non ha caricato un'immagine, puoi gestirlo come preferisci
	            // Ad esempio, puoi impostare un'immagine di default o mostrare un messaggio di errore
	        }	        
	        if (bindingResult.hasErrors()) {
	        	model.addAttribute("errori",bindingResult);
        		model.addAttribute("vagone", vagone);
	        	return "/admin/formCreaVagone";
	        }
	        // Nessun errore di validazione, salvare il vagone nel database
	        vagoneService.crea(vagone);
	        return "redirect:/treno/formCrea"; 
	    }
	    
//UPDATE	    
	    @GetMapping("/modifica-vagone/{id}")
	    public String showEditVagoneForm(@PathVariable int id, Model model) {
	        Vagone vagone = vagoneService.find(id);
	        if (vagone == null) {
	            // Se il vagone con l'id specificato non esiste, puoi gestire l'errore come preferisci
	            // Ad esempio, puoi reindirizzare a una pagina di errore o mostrare un messaggio
	            return "redirect:/admin/crea-vagone";
	        }
	        	        
	        // Converti l'immagine in Base64 e impostala nel model
	        if (vagone.getImgBytes() != null) {
	            String base64Image = Base64.getEncoder().encodeToString(vagone.getImgBytes());
	            vagone.setBase64Image(base64Image);
	        }
	        
	        model.addAttribute("vagone", vagone);
	        return "/admin/formModificaVagone";
	    }
	    
	    
	    @PostMapping("/modificaVagone")
	    public String saveModificheVagone(@Valid @ModelAttribute("vagone") Vagone vagone, BindingResult bindingResult, Model model) {
	    	
	    	// Ottieni l'immagine come MultipartFile
	        MultipartFile file = vagone.getImg();        
	        // Controlla se l'utente ha caricato effettivamente un'immagine
	        if (file != null && !file.isEmpty()) {
	            try {
	                // Converte l'immagine in un array di byte
	                byte[] imageBytes = file.getBytes();
	                // Salva l'array di byte nel campo img del vagone
	                vagone.setImgBytes(imageBytes);
	            } catch (IOException e) {
	                e.printStackTrace();
	                model.addAttribute("errore", "Errore durante il caricamento dell'immagine");
	                return "/admin/formCreaVagone";
	            }
	        } else {
	            // L'utente non ha caricato un'immagine, puoi gestirlo come preferisci
	            // Ad esempio, puoi impostare un'immagine di default o mostrare un messaggio di errore
	        }	   
	    	
	        // Controlla se ci sono errori di validazione
	        if (bindingResult.hasErrors()) {
	        	model.addAttribute("errori",bindingResult);
        		model.addAttribute("vagone", vagone);	            
        		return "/admin/formModificaVagone";
	        }
	        // Effettua il salvataggio delle modifiche nel database
	        vagoneService.update(vagone);
	        // Reindirizza alla pagina di elenco dei vagoni o a un'altra pagina di conferma
	        return "redirect:/treno/formCrea";
	    }
	    
//DELETE
	    @GetMapping("/eliminaVagone/{id}")
	    public String eliminaVagone(@PathVariable int id, RedirectAttributes redirectAttributes) {
	    	
	        Vagone vagone = vagoneService.find(id);
	        if (vagone == null) {
	            // Il vagone con l'id specificato non esiste, puoi gestire l'errore come preferisci
	            // Ad esempio, puoi reindirizzare a una pagina di errore o mostrare un messaggio
	            return "redirect:/treno/formCrea";
	        }
	        
	        vagoneService.delete(vagone);
            redirectAttributes.addFlashAttribute("message","Vagon '" + id + "' successfully deleted");

	        return "redirect:/treno/formCrea";
	    }
	    
	    
	}


