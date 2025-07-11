package com.korbiztech.product.cocs.CM.OR.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korbiztech.product.cocs.CM.OR.service.ORB030_Service;

@RestController
@RequestMapping("/api/ORB030/")
public class ORB030_RestController {
    
    @Autowired
    ORB030_Service service;
    
}
