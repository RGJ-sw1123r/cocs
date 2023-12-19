package com.korbiztech.product.cocs.CM.EQ.restController;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korbiztech.product.cocs.CM.EQ.service.EQC040_Service;
import com.korbiztech.product.cocs.CM.EQ.vo.EQC040_VO;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/EQC040")
public class EQC040_RestController {

	@Resource(name = "EQC040_Service")
	EQC040_Service eqcService;

	@GetMapping("/selectGrid")
	public List<HashMap<String, ?>> selectGrid(EQC040_VO params) {
		return eqcService.selectGrid(params);
	}

	@PutMapping("/{gridId}/gridData")
	public ResponseEntity<?> gridData(HttpServletRequest request) {
		return eqcService.saveGridData(request);
	}
}