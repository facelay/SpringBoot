package com.imooc;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.imooc.dataobject.ProductCategory;
import com.imooc.dataobject.ProductInfo;
import com.imooc.repository.ProductCategoryRepository;
import com.imooc.repository.ProductInfoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellApplicationTests {

	@Autowired
	private ProductCategoryRepository pcr;

	@Autowired
	private ProductInfoRepository pir;

	@Test
	public void contextLoads() {
	}

	@Test
	public void categoryRepository() {
		ProductCategory category = pcr.findOne(1);
		System.out.println(category.toString());
	}

	@Test
	public void saveCategory() {
		ProductCategory pc = new ProductCategory();
		pc.setCategoryName("热榜");
		pc.setCategoryType(2);
		ProductCategory category = pcr.save(pc);
	}

	@Test
	public void findByCategoryTypeIn() {
		List<Integer> list = Arrays.asList(2, 3, 4);
		List<ProductCategory> result = pcr.findByCategoryTypeIn(list);
		System.out.println(result.size());
	}

	@Test
	public void saveProductInfo() {
		ProductInfo pi = new ProductInfo();
		pi.setProductId("123456");
		pi.setProductName("皮蛋粥");
		pi.setProductPrice(new BigDecimal(3.2));
		pi.setProductStock(100);
		pi.setProductDescription("很好喝的粥");
		pi.setProductIcon("http://www.sigenaiba.cn/integ/pic/1.jpg");
		pi.setProductStatus(0);
		pi.setCategoryType(2);

		pir.save(pi);

	}

}
