package com.korbiztech.product.cocs.CM.BG.restController;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korbiztech.product.cocs.CM.BG.service.BGE010_Service;
import com.korbiztech.product.cocs.CM.BG.vo.BGE010_VO;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/api/BGE010")
public class BGE010_RestController {

    @Resource(name = "BGE010_Service")
    private BGE010_Service bgeService;

    @GetMapping(value = "/{tabName}/gridData")
    public List<HashMap<String, ?>> getGridData(@PathVariable String tabName, BGE010_VO params) {
        return bgeService.getGridData(tabName, params);
    }
    
}
