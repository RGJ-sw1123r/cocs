package com.korbiztech.product.cocs.CM.OR.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korbiztech.product.cocs.CM.OR.service.ORB040_Service;

@RestController
@RequestMapping("/api/ORB040/")
public class ORB040_RestController {

    @Autowired
    ORB040_Service service;
    
}
