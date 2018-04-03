package com.imooc.service;

import java.util.List;

import com.imooc.dataobject.ProductCategory;

public interface CategoryService {

	ProductCategory findOne(Integer categoryId);

	List<ProductCategory> finAll();

	List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

	ProductCategory save(ProductCategory pc);
}
