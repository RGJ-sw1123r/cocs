package com.korbiztech.product.cocs.AS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("QM_ViewController")
@RequestMapping("/QM")
public class ViewController {
    
	private String PATH_PREFIX = "QM/";
	
    @GetMapping("/{prefix:(?:AS)}/{programId}")
    public String handleRequest(Model model, @PathVariable String prefix, @PathVariable String programId) {
        return PATH_PREFIX + prefix + "/" + programId;
    }
    
}
