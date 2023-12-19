package com.korbiztech.product.cocs.CM.BG.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.korbiztech.product.cocs.CM.BG.vo.BGE020_VO;

@Mapper
public interface BGE020_DAO {
    
    List<HashMap<String, ?>> selectGubu();

    List<HashMap<String, ?>> selectResource(BGE020_VO params);

    List<HashMap<String, ?>> selectGrid(BGE020_VO params);
}
