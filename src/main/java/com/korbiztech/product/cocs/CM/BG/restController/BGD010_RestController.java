package com.korbiztech.product.cocs.CM.BG.restController;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korbiztech.product.cocs.CM.BG.service.BGD010_Service;
import com.korbiztech.product.cocs.CM.BG.vo.BGD010_VO;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/api/BGD010")
public class BGD010_RestController {

    @Resource(name = "BGD010_Service")
    private BGD010_Service bgdService;

    @GetMapping("/selectSite")
    public List<HashMap<String, ?>> selectSite() {
        return bgdService.selectSite();
    }
    
    @GetMapping("/selectDate")
    public List<HashMap<String, ?>> selectDate() {
        return bgdService.selectDate();
    }

    @GetMapping("/selectParentGrid")
    public List<HashMap<String, ?>> selectParentGrid(BGD010_VO params) {
        return bgdService.selectParentGrid(params);
    }

    @GetMapping("/selectChildGrid")
    public List<HashMap<String, ?>> selectChildGrid(BGD010_VO params) {
        return bgdService.selectChildGrid(params);
    }

    @GetMapping("/selectTree")
    public List<HashMap<String, ?>> selectTree(BGD010_VO params) {
        return bgdService.selectTree(params);
    }
}
