package com.korbiztech.product.cocs.COM.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Menu_DAO {

	List<HashMap<String, ?>> getMenuList();

}
