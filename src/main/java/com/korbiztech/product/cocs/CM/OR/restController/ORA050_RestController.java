package com.korbiztech.product.cocs.CM.OR.restController;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korbiztech.product.cocs.CM.OR.service.ORA050_Service;

@RestController
@RequestMapping("/OR")
public class ORA050_RestController {
    
    @Autowired
    ORA050_Service service;

    @GetMapping("/ORA050/selectTree")
    public List<HashMap<String, Object>> selectTree() {
        return service.selectTree();
    }
}
