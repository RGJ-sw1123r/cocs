package com.korbiztech.product.cocs.CM.BG.restController;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korbiztech.product.cocs.CM.BG.service.BGA040_Service;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/BGA040")
public class BGA040_RestController {
    
    @Autowired
    BGA040_Service bgaService;

    @GetMapping("/selectGrid")
    public List<HashMap<String, ?>> selectGrid() {
        return bgaService.selectGrid();
    }

    @PutMapping("/{gridId}/gridData")
    public ResponseEntity<?> saveGridData(HttpServletRequest request) {
        return bgaService.saveGridData(request);
    }
}
