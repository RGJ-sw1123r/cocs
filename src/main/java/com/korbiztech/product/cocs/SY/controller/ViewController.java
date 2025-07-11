package com.korbiztech.product.cocs.SY.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("SY_ViewController")
@RequestMapping("/SY")
public class ViewController {

	private String PATH_PREFIX = "SY/";

    @GetMapping("/{prefix:(?:SA|SB|SC|SD|SE|SF|SH)}/{programId}")
    public String handleRequest(Model model, @PathVariable String prefix, @PathVariable String programId) {
        return PATH_PREFIX + prefix + "/" + programId;
    }

}
