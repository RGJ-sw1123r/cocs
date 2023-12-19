package com.korbiztech.product.cocs.CM.EQ.restController;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korbiztech.product.cocs.CM.EQ.service.EQA010_Service;
import com.korbiztech.product.cocs.CM.EQ.vo.EQA010_VO;

@RestController
@RequestMapping("/api/EQA010")
public class EQA010_RestController {

    @Autowired
    EQA010_Service eqaService;

    @GetMapping("/selectSite")
    public List<HashMap<String, ?>> selectSite() {
        return eqaService.selectSite();
    }

    @GetMapping("/selectParentGrid")
    public List<HashMap<String, ?>> selectParentGrid(EQA010_VO params) {
        return eqaService.selectParentGrid(params);
    }
}
