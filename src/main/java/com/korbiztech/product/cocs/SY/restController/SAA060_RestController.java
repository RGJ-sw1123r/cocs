package com.korbiztech.product.cocs.SY.restController;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korbiztech.product.cocs.SY.service.SAA060_Service;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/SAA060")
public class SAA060_RestController {

	@Resource(name = "SAA060_Service")
	private SAA060_Service service;

	@GetMapping(value = "/{tabName}/gridData")
	public List<HashMap<String, ?>> getGridData(@PathVariable String tabName) {
		return service.getGridData(tabName);
	}

	@PutMapping(value = "/{tabName}/gridData")
	public ResponseEntity<?> saveGridData(HttpServletRequest request, @PathVariable String tabName) {
		return service.saveGridData(request, tabName);
	}

}
