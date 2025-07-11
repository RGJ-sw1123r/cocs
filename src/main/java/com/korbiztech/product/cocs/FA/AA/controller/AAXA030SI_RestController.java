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

import com.korbiztech.product.cocs.FA.AA.service.AAXA030SI_Service;
import com.korbiztech.product.cocs.FA.AA.vo.paramVO;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/AAXA030SI/")
public class AAXA030SI_RestController {
	
    @Autowired
    AAXA030SI_Service service;

    @GetMapping("selectList") 
    public List<HashMap<String, ?>> selectList(paramVO searchCondition){
        System.out.println(searchCondition);
        return service.selectList(searchCondition);
    }

    @GetMapping("deptList") 
    public List<HashMap<String, ?>> deptList(paramVO searchCondition){
        return service.deptList(searchCondition);
    }

    
    @GetMapping("empList") 
    public List<HashMap<String, ?>> empList(paramVO searchCondition){
        return service.empList(searchCondition);
    }

    @GetMapping("costList") 
    public List<HashMap<String, ?>> costList(paramVO searchCondition){
        return service.costList(searchCondition);
    }

    @GetMapping("gongList") 
    public List<HashMap<String, ?>> gongList(paramVO searchCondition){
        return service.gongList(searchCondition);
    }

    @GetMapping("govList") 
    public List<HashMap<String, ?>> govList(paramVO searchCondition){
        return service.govList(searchCondition);
    }

    @GetMapping("gongsaList") 
    public List<HashMap<String, ?>> gongsaList(paramVO searchCondition){
        return service.gongsaList(searchCondition);
    }

    @GetMapping("bonsaList") 
    public List<HashMap<String, ?>> bonsaList(paramVO searchCondition){
        return service.bonsaList(searchCondition);
    }

    @GetMapping("taxpayList") 
    public List<HashMap<String, ?>> taxpayList(paramVO searchCondition){
        return service.taxpayList(searchCondition);
    }

    @GetMapping("siteList") 
    public List<HashMap<String, ?>> siteList(paramVO searchCondition){
        return service.siteList(searchCondition);
    }

    @GetMapping("subcontList") 
    public List<HashMap<String, ?>> subcontList(paramVO searchCondition){
        return service.subcontList(searchCondition);
    }

    @PutMapping("{gridName}/gridData")
	public ResponseEntity<?> saveGridData(HttpServletRequest request, @PathVariable String gridName) {
        System.out.println(request+" / "+gridName);
		return service.saveGridData(request, gridName);
    }
}
