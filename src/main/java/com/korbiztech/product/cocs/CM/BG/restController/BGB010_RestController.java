package com.korbiztech.product.cocs.CM.BG.restController;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korbiztech.product.cocs.CM.BG.service.BGB010_Service;

@RestController
@RequestMapping("/api/BGB010")
public class BGB010_RestController {
    
    @Autowired
    BGB010_Service bgbService;

    @GetMapping("/selectSite")
    public List<HashMap<String, ?>> selectSite() {
        return bgbService.selectSite();
    }
}
