package com.korbiztech.product.cocs.CM.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("CM_ViewController")
@RequestMapping("/CM")
public class ViewController {

	private String PATH_PREFIX = "CM/";

    @GetMapping("/{prefix:(?:EQ|OR|BG)}/{programId}")
    public String handleRequest(Model model, @PathVariable String prefix, @PathVariable String programId) {
        return PATH_PREFIX + prefix + "/" + programId;
    }
}