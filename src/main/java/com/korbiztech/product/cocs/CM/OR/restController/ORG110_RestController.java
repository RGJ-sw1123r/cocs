package com.korbiztech.product.cocs.CM.OR.restController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korbiztech.product.cocs.CM.OR.service.ORG110_Service;
import com.korbiztech.product.cocs.CM.OR.vo.ORG110_VO;

import jakarta.annotation.Resource;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/ORG110")
public class ORG110_RestController {
    
    @Resource(name = "ORG110_Service")
    private ORG110_Service orgService;

    @GetMapping(value = "/{tabName}/gridData")
    public List<HashMap<String, ?>> getGridData(@PathVariable String tabName, ORG110_VO params) {
        return orgService.getGridData(tabName, params);
    }
    
}
