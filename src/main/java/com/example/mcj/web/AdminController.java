package com.example.mcj.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
public class AdminController {


    
    /*
     * ovo ne moze ovde, jer je Controller, a ne RestController
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    */
    
	@RequestMapping(value = "/{id}", produces = "text/html")
	public String test(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("itemId", id);
        uiModel.addAttribute("fields", null);
        
        return "admin/test";
		
	}
	
}