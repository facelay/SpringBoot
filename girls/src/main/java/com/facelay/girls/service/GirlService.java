package com.facelay.girls.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.facelay.girls.entity.Girl;
import com.facelay.girls.enums.ResultEnum;
import com.facelay.girls.handler.GirlException;
import com.facelay.girls.repository.GirlRepository;

/**
 * Service层
 * 
 * @author facelay
 * @date 2018年3月31日 下午4:39:56
 * @version 1.0
 */
@Service
public class GirlService {

	@Resource
	private GirlRepository girlRepository;

	@Transactional
	public void insertTwo() {

		Girl g1 = new Girl();
		g1.setAge(19);
		g1.setCupSize("D");
		girlRepository.save(g1);

		Girl g2 = new Girl();
		g2.setAge(18);
		g2.setCupSize("C");
		girlRepository.save(g2);
	}

	public void getAge(Integer id) throws Exception {
		Girl girl = girlRepository.findOne(id);
		Integer age = girl.getAge();
		if (age < 10) {
			throw new GirlException(ResultEnum.PAIMARY_SCHOOL);
		} else if (age > 10 && age < 16) {
			throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
		}
	}
}
