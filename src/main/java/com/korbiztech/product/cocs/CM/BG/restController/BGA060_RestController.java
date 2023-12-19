package com.korbiztech.product.cocs.CM.BG.restController;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korbiztech.product.cocs.CM.BG.service.BGA060_Service;
import com.korbiztech.product.cocs.CM.BG.vo.BGA060_VO;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/api/BGA060")
public class BGA060_RestController {
    
    @Resource(name = "BGA060_Service")
    BGA060_Service bgaService;

    @GetMapping("/selectSite")
    public List<HashMap<String, ?>> selectSite() {
        return bgaService.selectSite();
    }

    @GetMapping("/selectChsu")
    public List<HashMap<String, ?>> selectChsu(BGA060_VO params) {
        return bgaService.selectChsu(params);
    }

    @GetMapping("/selectGubu")
    public List<HashMap<String, ?>> selectGubu() {
        return bgaService.selectGubu();
    }

    @GetMapping("/selectGrid")
    public List<HashMap<String, ?>> selectGrid(BGA060_VO params) {
        return bgaService.selectGrid(params);
    }
}
