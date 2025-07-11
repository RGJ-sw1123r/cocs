package com.korbiztech.product.cocs.COM.vo;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FileParamsVO {

	private String name;
    private String ext;
    private String type;
    private long size;
    private String status;
    private String hashedFileName;
    private Map<String, Object> extraParams;
    
}
