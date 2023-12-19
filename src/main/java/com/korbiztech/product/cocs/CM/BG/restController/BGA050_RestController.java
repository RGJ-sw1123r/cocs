package com.korbiztech.product.cocs.CM.BG.restController;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korbiztech.product.cocs.CM.BG.service.BGA050_Service;
import com.korbiztech.product.cocs.CM.BG.vo.BGA050_VO;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/api/BGA050")
public class BGA050_RestController {
    
    @Resource(name = "BGA050_Service")
    BGA050_Service bgaService;

    @GetMapping("/selectSite")
    public List<HashMap<String, ?>> selectSite() {
        return bgaService.selectSite();
    }

    @GetMapping("/selectChsu")
    public List<HashMap<String, ?>> selectChsu(BGA050_VO params) {
        return bgaService.selectChsu(params);
    }

    @GetMapping("/selectGrid")
    public List<HashMap<String, ?>> selectGrid(BGA050_VO params) {
        return bgaService.selectGrid(params);
    }

    @GetMapping("/selectAmt")
    public List<HashMap<String, ?>> selectAmt(BGA050_VO params) {
        return bgaService.selectAmt(params);
    }
}
