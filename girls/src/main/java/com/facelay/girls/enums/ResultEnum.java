package com.facelay.girls.enums;

public enum ResultEnum {
	UNKONW_ERROR(-1, "未知错误"), SUCCESS(0, "成功"), PAIMARY_SCHOOL(100, "你还在上小学吧"), MIDDLE_SCHOOL(101, "你可能还在上初中");
	private Integer code;
	private String msg;

	private ResultEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

}
