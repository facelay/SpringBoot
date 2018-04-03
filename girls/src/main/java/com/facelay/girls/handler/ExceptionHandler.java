package com.facelay.girls.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.facelay.girls.utils.ResultUtils;

@RestControllerAdvice
public class ExceptionHandler {

	private final static Logger log = LoggerFactory.getLogger(ExceptionHandler.class);

	@SuppressWarnings("rawtypes")
	@org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
	public Result handler(Exception e) {
		if (e instanceof GirlException) {
			GirlException girlException = (GirlException) e;
			return ResultUtils.error(girlException.getCode(), girlException.getMessage());
		} else {
			log.info("【系统异常】{}", e);
			return ResultUtils.error(-1, "未知错误");
		}
	}
}
