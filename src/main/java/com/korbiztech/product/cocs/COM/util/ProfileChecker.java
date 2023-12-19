package com.korbiztech.product.cocs.COM.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ProfileChecker {

	@Autowired
	private Environment environment;

	public boolean isDevProfileActive() {
		String[] activeProfiles = environment.getActiveProfiles();
		for (String profile : activeProfiles) {
			if ("dev".equals(profile)) {
				return true;
			}
		}
		return false;
	}
	
}
