package com.facelay.girls.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.facelay.girls.entity.Girl;
import com.facelay.girls.handler.Result;
import com.facelay.girls.repository.GirlRepository;
import com.facelay.girls.service.GirlService;
import com.facelay.girls.utils.ResultUtils;

@RestController
public class GirlController {

	@Resource
	private GirlRepository girlRepository;

	@Resource
	private GirlService girlService;

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	@GetMapping(value = "/girls")
	public List<Girl> girlList() {
		return girlRepository.findAll();
	}

	/**
	 * 新增
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@PostMapping(value = "/girls")
	public Result<Girl> addGirl(@Valid Girl g, BindingResult br) {
		if (br.hasErrors()) {
			return null;
			// return ResultUtils.error(1,
			// br.getFieldError().getDefaultMessage());
		}
		g.setAge(g.getAge());
		g.setCupSize(g.getCupSize());

		return ResultUtils.success(girlRepository.save(g));
	}

	/**
	 * 查询单个
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/girls/{id}")
	public Girl getGirl(@PathVariable(value = "id") Integer id) {
		return girlRepository.findOne(id);
	}

	/**
	 * 更新Girl信息
	 * 
	 * @param id
	 * @param age
	 * @param cupSize
	 * @return
	 */
	@PutMapping(value = "/girls/{id}")
	public Girl updateGirl(@PathVariable("id") Integer id, @RequestParam("age") Integer age,
			@RequestParam("cupSize") String cupSize) {
		Girl g = new Girl();
		g.setId(id);
		g.setAge(age);
		g.setCupSize(cupSize);
		return girlRepository.save(g);
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/girls/{id}")
	public void delGirl(@PathVariable(value = "id") Integer id) {
		girlRepository.delete(id);
	}

	/*
	 * 通过年龄查询
	 */
	@GetMapping(value = "/girls/age/{age}")
	public List<Girl> getGirlByAge(@PathVariable(value = "age") Integer age) {
		return girlRepository.findByAge(age);
	}

	/**
	 * 同时插入两个女生，测试事务
	 */
	@PostMapping(value = "/girls/two")
	public void insertTwo() {
		girlService.insertTwo();
	}

	@GetMapping(value = "/girls/getAge/{id}")
	public void getAge(@PathVariable(value = "id") Integer id) throws Exception {
		girlService.getAge(id);
	}
}
