package com.korbiztech.product.cocs.CM.OR.restController;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korbiztech.product.cocs.CM.OR.service.ORG100_Service;
import com.korbiztech.product.cocs.CM.OR.vo.ORG100_VO;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/api/ORG100")
public class ORG100_RestController {
    
    @Resource(name = "ORG100_Service")
    ORG100_Service orgService;

    @GetMapping("/selectSite")
    public List<HashMap<String, ?>> selectSite() {
        return orgService.selectSite();
    }

    @GetMapping("/selectYear")
    public List<HashMap<String, ?>> selectYear() {
        return orgService.selectYear();
    }

    @GetMapping("/selectGrid")
    public List<HashMap<String, ?>> selectGrid(ORG100_VO params) {
        return orgService.selectGrid(params);
    }
}
