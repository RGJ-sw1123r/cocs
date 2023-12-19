package com.korbiztech.product.cocs.CM.BG.restController;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.korbiztech.product.cocs.CM.BG.service.BGA030_Service;
import com.korbiztech.product.cocs.CM.BG.vo.paramVO;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/BGA030")
public class BGA030_RestController {
    
    @Autowired
    BGA030_Service bgaService;

    @GetMapping("/selectSite")
    public List<HashMap<String, ?>> selectSite() {
        return bgaService.selectSite();
    }
    
    @GetMapping("/selectChsu")
    public List<HashMap<String, ?>> selectChsu(paramVO params) {
        return bgaService.selectChsu(params);
    }
    
    @GetMapping("/selectParentGrid")
    public List<HashMap<String, ?>> selectParentGrid(paramVO params) {
        return bgaService.selectParentGrid(params);
    }

    @GetMapping("/selectChildGrid")
    public List<HashMap<String, ?>> selectChildGrid(paramVO params) {
        return bgaService.selectChildGrid(params);
    }
    
    @GetMapping("/selectThreeTree")
    public List<HashMap<String, ?>> selectThreeTree(paramVO params) {
        return bgaService.selectThreeTree(params);
    }

    @GetMapping("/selectFourTree")
    public List<HashMap<String, ?>> selectFourTree(paramVO params) {
        return bgaService.selectFourTree(params);
    }

    @GetMapping("/selectGogu")
    public List<HashMap<String, ?>> selectGogu(paramVO params) {
        return bgaService.selectGogu(params);
    }
    
    @GetMapping("/selectAddGJ")
    public List<HashMap<String, ?>> selectAddGJ(paramVO params) {
        return bgaService.selectAddGJ(params);
    }

    @GetMapping("/selectAddItem")
    public List<HashMap<String, ?>> selectAddItem(paramVO params) {
        return bgaService.selectAddItem(params);
    }

    @GetMapping("/selectGubu")
    public List<HashMap<String, ?>> selectGubu() {
        return bgaService.selectGubu();
    }

    @GetMapping("/selectDivideItem")
    public List<HashMap<String, ?>> selectDivideItem(paramVO params) {
        return bgaService.selectDivideItem(params);
    }

    @PostMapping("/insertAddGJ")
    public void insertAddGJ(@RequestBody paramVO params) {
        bgaService.insertAddGJ(params);
    }

    @PostMapping("/insertDivideItems")
    public void insertDivideItems(@RequestBody paramVO params) {
        bgaService.insertDivideItems(params);
    }

    @PutMapping("/{gridId}/gridData")
    public ResponseEntity<?> gridData(HttpServletRequest request, @PathVariable String gridId) {
        return bgaService.saveGridData(request, gridId);
    }

    @PostMapping("/files")
    public ResponseEntity<?> uploadFiles(@RequestParam("files") List<MultipartFile> files,
    		@RequestParam("params") String paramsJson) {
    	return bgaService.uploadFiles(files, paramsJson);
	}
}