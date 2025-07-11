package com.korbiztech.product.cocs.COM.vo;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private MemberVO member;
	private List<GrantedAuthority> authorities;
	
	public CustomUserDetails(MemberVO member) {
		this.member = member;
		this.authorities = Optional.ofNullable(member.getRoles())
				.orElse(Collections.emptyList())
				.stream()
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return member.getUsersPw();
	}

	@Override
	public String getUsername() {
		return member.getLoginId();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public MemberVO getMember() {
		return this.member;
	}
	
}
