package com.korbiztech.product.cocs.CM.OR.restController;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korbiztech.product.cocs.CM.OR.service.ORB010_Service;
import com.korbiztech.product.cocs.CM.OR.vo.ORB010_VO;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/api/ORB010")
public class ORB010_RestController {
    
    @Resource(name = "ORB010_Service")
    private ORB010_Service oraService;

    @GetMapping("/selectSite")
    public List<HashMap<String, ?>> selectSite() {
        return oraService.selectSite();
    }

    @GetMapping("/selectMainGrid")
    public List<HashMap<String, ?>> selectMainGrid(ORB010_VO params) {
        return oraService.selectMainGrid(params);
    }

    @GetMapping("/selectSubGrid")
    public List<HashMap<String, ?>> selectSubGrid(ORB010_VO params) {
        return oraService.selectSubGrid(params);
    }
}
