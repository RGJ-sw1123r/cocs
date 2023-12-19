package com.korbiztech.product.cocs.CM.EQ.restController;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korbiztech.product.cocs.CM.EQ.service.EQA020_Service;
import com.korbiztech.product.cocs.CM.EQ.vo.EQA020_VO;

@RestController
@RequestMapping("/api/EQA020")
public class EQA020_RestController {

    @Autowired
    EQA020_Service eqaService;
    
    @GetMapping("/selectSite")
    public List<HashMap<String, ?>> selectSite() {
        return eqaService.selectSite();
    }

    @GetMapping("/selectGrid")
    public List<HashMap<String, ?>> selectGrid(EQA020_VO params) {
        return eqaService.selectGrid(params);
    }
}
