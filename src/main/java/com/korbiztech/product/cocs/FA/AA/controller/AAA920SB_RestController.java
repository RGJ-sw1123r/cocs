package com.korbiztech.product.cocs.FA.AA.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korbiztech.product.cocs.FA.AA.service.AAA920SB_Service;
import com.korbiztech.product.cocs.FA.AA.vo.paramVO;

@RestController
@RequestMapping("/api/AAA920SB/")
public class AAA920SB_RestController {
	
    @Autowired
    AAA920SB_Service service;
    
    @GetMapping("selectList") 
    public List<HashMap<String, ?>> selectList(paramVO searchCondition){
        System.out.println(searchCondition);
        
        return service.selectList(searchCondition);
    }
}
