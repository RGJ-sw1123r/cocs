package com.korbiztech.product.cocs.COM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.korbiztech.product.cocs.COM.dao.Auth_DAO;
import com.korbiztech.product.cocs.COM.vo.CustomUserDetails;
import com.korbiztech.product.cocs.COM.vo.MemberVO;

@Service("auth_Service")
public class Auth_Service implements UserDetailsService {

	@Autowired
	private Auth_DAO authDao;
	
	@Override
	public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
		MemberVO member = authDao.findOne(loginId).orElseThrow(() -> new UsernameNotFoundException("User not found"));
		return new CustomUserDetails(member);
	}

}
