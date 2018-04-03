package com.facelay.girls.handler;

import com.facelay.girls.enums.ResultEnum;

public class GirlException extends RuntimeException {

	private static final long serialVersionUID = -8959304554741041782L;

	private Integer code;

	public GirlException(ResultEnum resultEnum) {
		super(resultEnum.getMsg());
		this.code = resultEnum.getCode();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
