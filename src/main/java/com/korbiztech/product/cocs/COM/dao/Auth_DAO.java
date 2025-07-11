package com.korbiztech.product.cocs.COM.dao;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.korbiztech.product.cocs.COM.vo.MemberVO;

@Mapper
public interface Auth_DAO {

	Optional<MemberVO> findOne(String loginId);
	
}
