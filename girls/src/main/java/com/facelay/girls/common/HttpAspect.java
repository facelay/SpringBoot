package com.facelay.girls.common;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class HttpAspect {

	private final static Logger log = LoggerFactory.getLogger(HttpAspect.class);

	@Pointcut("execution(public * com.facelay.girls.controller.GirlController.*(..))")
	public void log() {
	}

	@Before(value = "log()")
	public void before() {
		log.info("Before Aspect ++++++++++++++++++++++");
	}

	@After(value = "log()")

	public void after(JoinPoint jp) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		// Url
		log.info("URL={}", request.getRequestURI());

		// method
		log.info("method={}", request.getMethod());

		// ip
		log.info("ip={}", request.getRemoteAddr());

		// 类方法
		log.info("class_method={}", jp.getSignature().getDeclaringTypeName() + "." + jp.getSignature().getName());

		// 参数
		log.info("args={}", jp.getArgs());

		log.info("After Aspect ##########################");
	}

	@AfterReturning(returning = "obj", value = "log()")
	public void doAfterReturning(Object obj) {
		log.info("response={}", obj.toString());
	}

}
