package com.korbiztech.product.cocs.CM.BG.restController;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korbiztech.product.cocs.CM.BG.service.BGA010_Service;
import com.korbiztech.product.cocs.CM.BG.vo.BGA010_VO;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/BGA010")
public class BGA010_RestController {
    
    @Resource(name = "BGA010_Service")
    BGA010_Service bgaService;

    @GetMapping("/selectParentGrid")
    public List<HashMap<String, ?>> selectParentGrid(BGA010_VO params) {
        return bgaService.selectParentGrid(params);
    }

    @GetMapping("/selectChildGrid")
    public List<HashMap<String, ?>> selectChildGrid(BGA010_VO params) {
        return bgaService.selectChildGrid(params);
    }

    @PutMapping("/{gridId}/gridData")
    public ResponseEntity<?> gridData(HttpServletRequest request) {
        return bgaService.saveGridData(request);
    }
}
