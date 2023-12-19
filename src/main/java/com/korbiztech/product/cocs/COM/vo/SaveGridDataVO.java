package com.korbiztech.product.cocs.COM.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveGridDataVO<T> {

	private String status;
	private int rownum;
	private T data;

}
