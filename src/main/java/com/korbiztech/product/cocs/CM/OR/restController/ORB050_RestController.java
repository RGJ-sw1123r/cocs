package com.korbiztech.product.cocs.CM.OR.restController;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korbiztech.product.cocs.CM.OR.service.ORB050_Service;
import com.korbiztech.product.cocs.CM.OR.vo.ORB050_VO;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/api/ORB050")
public class ORB050_RestController {
    
    @Resource(name = "ORB050_Service")
    private ORB050_Service oraService;

    @GetMapping("/selectSite")
    public List<HashMap<String, ?>> selectSite() {
        return oraService.selectSite();
    }

    @GetMapping(value = "/{tabName}/gridData")
    public List<HashMap<String, ?>> getGridData(@PathVariable String tabName, ORB050_VO params) {
        return oraService.getGridData(tabName, params);
    }
}
