package com.korbiztech.product.cocs.CM.OR.restController;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korbiztech.product.cocs.CM.OR.service.ORG020_Service;
import com.korbiztech.product.cocs.CM.OR.vo.ORG020_VO;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/api/ORG020")
public class ORG020_RestController {
    
    @Resource(name = "ORG020_Service")
    ORG020_Service orgService;

    @GetMapping("/selectGrid")
    public List<HashMap<String, ?>> selectGrid(ORG020_VO params) {
        return orgService.selectGrid(params);
    }

    @GetMapping("/selectGogu")
    public List<HashMap<String, ?>> selectGogu() {
        return orgService.selectGogu();
    }
}
