package org.lessons.java.controller.ApiController;

import java.util.List;

import org.lessons.java.DTO.TrenoDTO;
import org.lessons.java.service.TrenoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class ApiTrenoController {
	
	@Autowired
	private TrenoService trenoService;
	
	
    @GetMapping("/treni")
    public List<TrenoDTO> getTreni() {
        return trenoService.findAllWithVagoni();
    }
	
	
}
