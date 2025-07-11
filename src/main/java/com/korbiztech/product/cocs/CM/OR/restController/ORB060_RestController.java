package com.korbiztech.product.cocs.CM.OR.restController;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korbiztech.product.cocs.CM.OR.service.ORB060_Service;
import com.korbiztech.product.cocs.CM.OR.vo.ORB060_VO;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/api/ORB060")
public class ORB060_RestController {
    
    @Resource(name = "ORB060_Service")
    private ORB060_Service oraService;

    @GetMapping("/selectSite")
    public List<HashMap<String, ?>> selectSite() {
        return oraService.selectSite();
    }

    @GetMapping("/selectGrid")
    public List<HashMap<String, ?>> selectGrid(ORB060_VO params) {
        return oraService.selectGrid(params);
    }
}
