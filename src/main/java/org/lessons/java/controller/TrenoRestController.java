package org.lessons.java.controller;

import java.util.List;

import org.lessons.java.bean.Treno;
import org.lessons.java.service.TrenoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/treni")
public class TrenoRestController {

	@Autowired
    private TrenoService trenoService;

    //lista treni per parola chiave
    @GetMapping
    public List<Treno> index() {
        return trenoService.findAll();
    }
	
}
