package com.korbiztech.product.cocs.CM.BG.restController;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korbiztech.product.cocs.CM.BG.service.BGD020_Service;
import com.korbiztech.product.cocs.CM.BG.vo.BGD020_VO;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/api/BGD020")
public class BGD020_RestController {
    
    @Resource(name = "BGD020_Service")
    BGD020_Service bgdService;

    @GetMapping("/selectSite")
    public List<HashMap<String, ?>> selectSite() {
        return bgdService.selectSite();
    }

    @GetMapping("/selectDate")
    public List<HashMap<String, ?>> selectDate() {
        return bgdService.selectDate();
    }

    @GetMapping("/selectGrid")
    public List<HashMap<String, ?>> selectGrid(BGD020_VO params) {
        return bgdService.selectGrid(params);
    }
}
