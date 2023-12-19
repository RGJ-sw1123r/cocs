package com.korbiztech.product.cocs.FA.AA.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korbiztech.product.cocs.FA.AA.service.AAXA100SI_Service;
import com.korbiztech.product.cocs.FA.AA.vo.paramVO;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/AAXA100SI/")
public class AAXA100SI_RestController {    
    
    @Autowired
    AAXA100SI_Service service;

    @GetMapping("selectList") 
    public List<HashMap<String, ?>> selectList(paramVO searchCondition){
        System.out.println(searchCondition);
        
        return service.selectList(searchCondition);
    }

    @GetMapping("selectDetailList") 
    public List<HashMap<String, ?>> selectDetailList(paramVO searchCondition){
        System.out.println(searchCondition);
        
        return service.selectDetailList(searchCondition);
    }

    @PutMapping("{gridName}/gridData")
	public ResponseEntity<?> saveGridData(HttpServletRequest request, @PathVariable String gridName) {
        System.out.println(request+" / "+gridName);
		return service.saveGridData(request, gridName);
    }

}