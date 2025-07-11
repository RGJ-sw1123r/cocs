package com.korbiztech.product.cocs.CM.BG.restController;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korbiztech.product.cocs.CM.BG.service.BGE030_Service;
import com.korbiztech.product.cocs.CM.BG.vo.BGE030_VO;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/api/BGE030")
public class BGE030_RestController {

    @Resource(name = "BGE030_Service")
    BGE030_Service bgeService;

    @GetMapping("/selectSite")
    public List<HashMap<String, ?>> selectSite() {
        return bgeService.selectSite();
    }

    @GetMapping("/selectGrid")
    public List<HashMap<String, ?>> selectGrid(BGE030_VO params) {
        return bgeService.selectGrid(params);
    }
}
