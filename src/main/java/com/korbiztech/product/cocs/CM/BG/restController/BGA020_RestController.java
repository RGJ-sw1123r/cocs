package com.korbiztech.product.cocs.CM.BG.restController;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korbiztech.product.cocs.CM.BG.service.BGA020_Service;
import com.korbiztech.product.cocs.CM.BG.vo.BGA020_VO;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/api/BGA020")
public class BGA020_RestController {
    
    @Resource(name = "BGA020_Service")
    BGA020_Service bgaService;

    @GetMapping("/selectSite")
    public List<HashMap<String, ?>> selectSite() {
        return bgaService.selectSite();
    }

    @GetMapping("/selectGubu")
    public List<HashMap<String, ?>> selectGubu() {
        return bgaService.selectGubu();
    }

    @GetMapping("/selectChsu")
    public List<HashMap<String, ?>> selectChsu(BGA020_VO params) {
        return bgaService.selectChsu(params);
    }

    @GetMapping("/selectGrid")
    public List<HashMap<String, ?>> selectGrid(BGA020_VO params) {
        return bgaService.selectGrid(params);
    }
}
