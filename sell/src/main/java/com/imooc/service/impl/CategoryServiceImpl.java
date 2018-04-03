package com.imooc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.dataobject.ProductCategory;
import com.imooc.repository.ProductCategoryRepository;
import com.imooc.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private ProductCategoryRepository pcr;

	@Override
	public ProductCategory findOne(Integer categoryId) {
		return pcr.findOne(categoryId);
	}

	@Override
	public List<ProductCategory> finAll() {
		return pcr.findAll();
	}

	@Override
	public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
		return pcr.findByCategoryTypeIn(categoryTypeList);
	}

	@Override
	public ProductCategory save(ProductCategory pc) {
		return pcr.save(pc);
	}

}
