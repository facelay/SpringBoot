package com.imooc.dataobject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Entity
@Data
@DynamicUpdate
public class ProductCategory {

	/** 类目id. */
	@Id
	@GeneratedValue
	private Integer categoryId;

	/** 类目名称 */
	private String categoryName;

	/** 类目编号 */
	private Integer categoryType;

	@Override
	public String toString() {
		return "ProductCategory [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryType="
				+ categoryType + "]";
	}

	public ProductCategory() {
		super();
	}

}
