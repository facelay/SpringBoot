package com.imooc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imooc.dataobject.ProductInfo;

public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

	List<ProductInfo> findByProductStatus(Integer productStatus);

}
