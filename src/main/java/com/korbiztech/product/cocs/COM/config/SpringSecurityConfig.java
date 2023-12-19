package com.korbiztech.product.cocs.COM.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;

import jakarta.servlet.DispatcherType;

@Configuration
public class SpringSecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		OrRequestMatcher staticResources = new OrRequestMatcher(
			new AntPathRequestMatcher("/css/**"),
			new AntPathRequestMatcher("/img/**"),
			new AntPathRequestMatcher("/js/**"),
			new AntPathRequestMatcher("/font/**"),
			new AntPathRequestMatcher("/static/**")
		);
		
		http.csrf().disable().cors().disable()
			.headers()
				.frameOptions().disable()
				.and()
			.authorizeHttpRequests(request -> request
				.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
				.requestMatchers(staticResources).permitAll()
				.anyRequest().authenticated()
			)
			.sessionManagement()
				.invalidSessionUrl("/")
				.and()
			.formLogin(login -> login
				.loginPage("/login")
				.loginProcessingUrl("/api/auth/login")
				.usernameParameter("loginId")
				.passwordParameter("pw")
				.defaultSuccessUrl("/index", true)
				.permitAll()
			)
			.logout(logout -> logout
				.logoutUrl("/api/auth/logout")
				.permitAll()
			);
		return http.build();
	}
	
}
