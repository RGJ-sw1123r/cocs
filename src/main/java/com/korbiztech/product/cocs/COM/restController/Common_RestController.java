package com.korbiztech.product.cocs.COM.restController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.korbiztech.product.cocs.COM.service.Common_Service;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/COM")
public class Common_RestController {

	@Resource(name = "common_Service")
	private Common_Service commonService;

	@GetMapping(value = "/menu")
	public List<HashMap<String, ?>> getMenuList(HttpServletRequest request) {
		List<HashMap<String, ?>> menu = commonService.getMenuList();
		return menu;
	}

	@PostMapping(value = "/excel")
    public void uploadFiles(@RequestParam("excel") MultipartFile file, 
    		@RequestParam Map<String, String> allParams,
    		HttpServletResponse response) {
		commonService.SBExcelLoad(file, allParams, response);
	}
	
}
