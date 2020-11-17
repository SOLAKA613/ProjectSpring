package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Controlleur {

    @GetMapping("/go")
    public ModelAndView go() {
    	ModelAndView mav= new ModelAndView("page"); 
    	mav.addObject("prenom","Hassan");
	    return mav;
    }

	@GetMapping("/go2")
	public  String go2() {
		return "Hello2";
	}
	
}
