package com.facelay.girls.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facelay.girls.entity.Girl;

/**
 * @author facelay
 * @date 2018年3月31日 下午2:32:22
 * @version 1.0
 */
public interface GirlRepository extends JpaRepository<Girl, Integer> {
	// 通过年龄查询
	List<Girl> findByAge(Integer age);
}
