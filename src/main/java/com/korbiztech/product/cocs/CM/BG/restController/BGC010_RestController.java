package com.korbiztech.product.cocs.CM.BG.restController;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korbiztech.product.cocs.CM.BG.service.BGC010_Service;
import com.korbiztech.product.cocs.CM.BG.vo.BGC010_VO;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/api/BGC010")
public class BGC010_RestController {
    
    @Resource(name = "BGC010_Service")
    BGC010_Service bgcService;

    @GetMapping("/selectSite")
    public List<HashMap<String, ?>> selectSite() {
        return bgcService.selectSite();
    }

    @GetMapping("/selectChsu")
    public List<HashMap<String, ?>> selectChsu(BGC010_VO params) {
        return bgcService.selectChsu(params);
    }
}
