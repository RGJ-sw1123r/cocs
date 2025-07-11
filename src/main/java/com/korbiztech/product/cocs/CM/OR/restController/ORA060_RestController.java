package com.korbiztech.product.cocs.CM.OR.restController;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korbiztech.product.cocs.CM.OR.service.ORA060_Service;
import com.korbiztech.product.cocs.CM.OR.vo.ORA060_VO;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/api/ORA060")
public class ORA060_RestController {
    
    @Resource(name = "ORA060_Service")
    ORA060_Service oraService;

    @GetMapping("/selectGubu")
    public List<HashMap<String, ?>> selectGubu() {
        return oraService.selectGubu();
    }

    @GetMapping("/selectParentGrid")
    public List<HashMap<String, ?>> selectParentGrid(ORA060_VO params) {
        return oraService.selectParentGrid(params);
    }

    @GetMapping("/selectChildGrid_TP")
    public List<HashMap<String, ?>> selectChildGrid_TP(ORA060_VO params) {
        return oraService.selectChildGrid_TP(params);
    }
}
