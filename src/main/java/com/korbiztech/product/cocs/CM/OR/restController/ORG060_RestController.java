package com.korbiztech.product.cocs.CM.OR.restController;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korbiztech.product.cocs.CM.OR.service.ORG060_Service;
import com.korbiztech.product.cocs.CM.OR.vo.ORG060_VO;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/api/ORG060")
public class ORG060_RestController {
    
    @Resource(name = "ORG060_Service")
    ORG060_Service orgService;

    @GetMapping("/selectSubGrop")
    public List<HashMap<String, ?>> selectSubGrop(ORG060_VO params) {
        return orgService.selectSubGrop(params);
    }

    @GetMapping("/selectGrid")
    public List<HashMap<String, ?>> selectGrid(ORG060_VO params) {
        return orgService.selectGrid(params);
    }
}
