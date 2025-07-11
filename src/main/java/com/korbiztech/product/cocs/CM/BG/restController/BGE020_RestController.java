package com.korbiztech.product.cocs.CM.BG.restController;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korbiztech.product.cocs.CM.BG.service.BGE020_Service;
import com.korbiztech.product.cocs.CM.BG.vo.BGE020_VO;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/api/BGE020")
public class BGE020_RestController {

    @Resource(name = "BGE020_Service")
    BGE020_Service bgeService;

    @GetMapping("/selectGubu")
    public List<HashMap<String, ?>> selectGubu() {
        return bgeService.selectGubu();
    }

    @GetMapping("/selectResource")
    public List<HashMap<String, ?>> selectResource(BGE020_VO params) {
        return bgeService.selectResource(params);
    }

    @GetMapping("/selectGrid")
    public List<HashMap<String, ?>> selectGrid(BGE020_VO params) {
        return bgeService.selectGrid(params);
    }
}
