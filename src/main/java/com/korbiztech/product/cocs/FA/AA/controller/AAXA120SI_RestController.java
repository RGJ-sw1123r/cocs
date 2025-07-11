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

import com.korbiztech.product.cocs.FA.AA.service.AAXA120SI_Service;
import com.korbiztech.product.cocs.FA.AA.vo.paramVO;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/AAXA120SI/")
public class AAXA120SI_RestController {
    
    @Autowired
    AAXA120SI_Service service;

    @GetMapping("selectList") 
    public List<HashMap<String, ?>> selectList(paramVO searchCondition){
        System.out.println(searchCondition);
        return service.selectList(searchCondition);
    }

    @GetMapping("cardList") 
    public List<HashMap<String, ?>> cardList(){   
        return service.cardList();
    }

    @GetMapping("ownerList") 
    public List<HashMap<String, ?>> ownerList(){   
        return service.ownerList();
    }

    @GetMapping("deptList") 
    public List<HashMap<String, ?>> deptList(){   
        return service.deptList();
    }

    @GetMapping("custList") 
    public List<HashMap<String, ?>> custList(){   
        return service.custList();
    }

    @GetMapping("howtopayList") 
    public List<HashMap<String, ?>> howtopayList(){   
        return service.howtopayList();
    }

    @PutMapping("{gridName}/gridData")
	public ResponseEntity<?> saveGridData(HttpServletRequest request, @PathVariable String gridName) {
        System.out.println(request+" / "+gridName);
		return service.saveGridData(request, gridName);
    }
}
