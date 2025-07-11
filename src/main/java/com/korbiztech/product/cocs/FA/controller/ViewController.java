package com.korbiztech.product.cocs.FA.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("FA_ViewController")
@RequestMapping("/FA")
public class ViewController {

	private String PATH_PREFIX = "FA/";

    @GetMapping("/{prefix:(?:AA|AC)}/{programId}")
    public String handleRequest(Model model, @PathVariable String prefix, @PathVariable String programId) {
        return PATH_PREFIX + prefix + "/" + programId;
    }
}