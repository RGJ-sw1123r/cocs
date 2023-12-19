package com.korbiztech.product.cocs.FA.AA.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korbiztech.product.cocs.FA.AA.service.AAXA010SI_Service;
import com.korbiztech.product.cocs.FA.AA.vo.paramVO;

@RestController
@RequestMapping("/api/AAXA010SI/")
public class AAXA010SI_RestController {
	
    @Autowired
    AAXA010SI_Service service;

    @GetMapping("selectList") 
    public List<HashMap<String, ?>> selectList(paramVO searchCondition){
        System.out.println(searchCondition);
        
        return service.selectList(searchCondition);
    }
}
