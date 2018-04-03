package com.imooc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoggerTest {
	private final static Logger log = LoggerFactory.getLogger(LoggerTest.class);

	@Test
	public void test1() {
		String name = "facelay";
		String password = "123456";
		log.info("name:{},password:{}", name, password);
		log.error("ERROR+++++++++++++");
	}

}
