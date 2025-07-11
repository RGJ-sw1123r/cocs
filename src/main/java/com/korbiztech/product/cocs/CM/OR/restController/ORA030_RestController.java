package com.korbiztech.product.cocs.CM.OR.restController;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korbiztech.product.cocs.CM.OR.vo.paramVO;
import com.korbiztech.product.cocs.CM.OR.service.ORA030_Service;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/ORA030/")
public class ORA030_RestController {

    @Autowired
    ORA030_Service service;

    @GetMapping("selectList") //협력업체등록정보 기본 조회
    public List<HashMap<String, ?>> selectList(paramVO searchCondition){
        System.out.println(searchCondition.getCUST_POST());
        
        return service.selectList(searchCondition);
    }

    @GetMapping("bankList") //은행 코드 조회
    public List<HashMap<String, ?>> bankList(){
       
        return service.bankList();
    }

    @GetMapping("commList") //기술구분 조회
    public List<HashMap<String, ?>> commList(paramVO searchCondition){
        
        return service.commList(searchCondition);
    }

    @GetMapping("gongList") //등록공종 조회
    public List<HashMap<String, ?>> gongList(paramVO searchCondition){
        
        return service.gongList(searchCondition);
    }

    @GetMapping("tab02Info") //보유면허 기본 조회
    public List<HashMap<String, ?>> tab02Info(paramVO searchCondition){
        System.out.println(searchCondition);
        
        return service.tab02Info(searchCondition);
    }

    @GetMapping("postList") //지역명 조회
    public List<HashMap<String, ?>> postList(){

        return service.postList();
    }

    @GetMapping("tab03Info") //계약가능공증 기본 조회
    public List<HashMap<String, ?>> tab03Info(paramVO searchCondition){
        System.out.println(searchCondition);
        
        return service.tab03Info(searchCondition);
    }

    @GetMapping("tab04Info") //시공실적 기본 조회
    public List<HashMap<String, ?>> tab04Info(paramVO searchCondition){
        System.out.println(searchCondition);
        
        return service.tab04Info(searchCondition);
    }

    @GetMapping("tab05Info") //포상 기본 조회
    public List<HashMap<String, ?>> tab05Info(paramVO searchCondition){
        System.out.println(searchCondition);
        
        return service.tab05Info(searchCondition);
    }

    @GetMapping("tab06Info") //입찰이력관리 기본 조회
    public List<HashMap<String, ?>> tab06Info(paramVO searchCondition){
        System.out.println(searchCondition);
        
        return service.tab06Info(searchCondition);
    }

    @GetMapping("tab07Info") //제재현황 기본 조회
    public List<HashMap<String, ?>> tab07Info(paramVO searchCondition){
        System.out.println(searchCondition);
        
        return service.tab07Info(searchCondition);
    }

    @PutMapping("{tabName}/gridData")
	public ResponseEntity<?> saveGridData(HttpServletRequest request, @PathVariable String tabName) {
        System.out.println(request+" / "+tabName);
		return service.saveGridData(request, tabName);
    }
}
