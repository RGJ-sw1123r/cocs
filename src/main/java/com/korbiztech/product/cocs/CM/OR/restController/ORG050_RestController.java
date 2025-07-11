package com.korbiztech.product.cocs.CM.OR.restController;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korbiztech.product.cocs.CM.OR.service.ORG050_Service;
import com.korbiztech.product.cocs.CM.OR.vo.ORG050_VO;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/api/ORG050")
public class ORG050_RestController {
    
    @Resource(name = "ORG050_Service")
    ORG050_Service orgService;

    @GetMapping("/selectGrid")
    public List<HashMap<String, ?>> selectGrid(ORG050_VO params) {
        return orgService.selectGrid(params);
    }
}
