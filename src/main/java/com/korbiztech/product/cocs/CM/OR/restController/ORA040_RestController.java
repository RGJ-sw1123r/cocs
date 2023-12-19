package com.korbiztech.product.cocs.CM.OR.restController;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korbiztech.product.cocs.CM.OR.service.ORA040_Service;
import com.korbiztech.product.cocs.CM.OR.vo.ORA040_VO;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/api/ORA040")
public class ORA040_RestController {
    
    @Resource(name = "ORA040_Service")
    private ORA040_Service oraService;

    @GetMapping("/selectTree")
    public List<HashMap<String, ?>> selectTree() {
        return oraService.selectTree();
    }

    @GetMapping("/selectGrid")
    public List<HashMap<String, ?>> selectGrid(ORA040_VO params) {
        return oraService.selectGrid(params);
    }
}
