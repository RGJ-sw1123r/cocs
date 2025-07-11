package com.korbiztech.product.cocs.CM.OR.restController;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korbiztech.product.cocs.CM.OR.service.ORG010_Service;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/api/ORG010")
public class ORG010_RestController {
    
    @Resource(name = "ORG010_Service")
    ORG010_Service orgService;

    @GetMapping("/selectGrid")
    public List<HashMap<String, ?>> selectGrid() {
        return orgService.selectGrid();
    }
}
