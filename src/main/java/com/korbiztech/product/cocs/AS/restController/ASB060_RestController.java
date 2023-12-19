package com.korbiztech.product.cocs.AS.restController;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korbiztech.product.cocs.AS.service.ASB060_Service;
import com.korbiztech.product.cocs.AS.vo.paramVO;

@RestController
@RequestMapping("/api/ASB060/")
public class ASB060_RestController {

    @Autowired
    ASB060_Service asbService;

    @GetMapping("selectList") // 하자보수 보증처리현황 기본 조회
    public List<HashMap<String, ?>> selectList(paramVO param){
        System.out.println(param.getConstDivision());

		return asbService.selectList(param);
    }

    @GetMapping("constDivision") // 상단 SELECT 공사구분 조회
    public List<HashMap<String, ?>> constDivision(){
        return asbService.constDivision();
    }

     @GetMapping("constName") // 상단 SELECT 현장명 조회
    public List<HashMap<String, ?>> constName(){
        return asbService.constName();
    }

}
