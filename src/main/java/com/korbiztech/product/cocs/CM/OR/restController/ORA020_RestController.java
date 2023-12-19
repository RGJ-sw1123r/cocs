package com.korbiztech.product.cocs.CM.OR.restController;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korbiztech.product.cocs.CM.OR.service.ORA020_Service;
import com.korbiztech.product.cocs.CM.OR.vo.ORA020_VO;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/api/ORA020")
public class ORA020_RestController {
    
    @Resource(name = "ORA020_Service")
    private ORA020_Service oraService;

    @GetMapping("/selectTree")
    public List<HashMap<String, ?>> selectTree() {
        return oraService.selectTree();
    }

    @GetMapping("/selectGrid")
    public List<HashMap<String, ?>> selectGrid(ORA020_VO params) {
        return oraService.selectGrid(params);
    }
}
