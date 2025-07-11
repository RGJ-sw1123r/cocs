package com.korbiztech.product.cocs.CM.OR.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.korbiztech.product.cocs.CM.OR.vo.ORB050_VO;

@Mapper
public interface ORB050_DAO {
    
    List<HashMap<String, ?>> selectSite();

    List<HashMap<String, ?>> selectTab01Grid(ORB050_VO params);

    List<HashMap<String, ?>> selectTab02Grid(ORB050_VO params);

    List<HashMap<String, ?>> selectTab03Grid(ORB050_VO params);
}
