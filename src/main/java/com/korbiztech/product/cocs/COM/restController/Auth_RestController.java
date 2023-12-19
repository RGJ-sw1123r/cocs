package com.korbiztech.product.cocs.COM.restController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class Auth_RestController {

	@PostMapping("/login")
	public String login() {
		boolean isValidMember = true;
		if (isValidMember) return "index";
		else return "login";
	}

}
