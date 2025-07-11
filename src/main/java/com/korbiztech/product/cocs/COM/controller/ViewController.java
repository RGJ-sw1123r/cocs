package com.korbiztech.product.cocs.COM.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.korbiztech.product.cocs.COM.vo.CustomUserDetails;
import com.korbiztech.product.cocs.COM.vo.MemberVO;

@Controller("COM_ViewController")
public class ViewController {

	
	@GetMapping(value = { "/", "/index" })
	public String indexPage(Model model, Authentication authentication) {
		if (authentication  != null) {
			CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
			MemberVO member = customUserDetails.getMember();
			model.addAttribute("member", member);
		}
		return "index";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
}
