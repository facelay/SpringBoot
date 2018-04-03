package com.imooc.dataobject;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Entity
@Data
@DynamicUpdate
public class ProductInfo {

	@Id
	private String productId;

	/** 名称 */
	private String productName;

	/** 单价 */
	private BigDecimal productPrice;

	/** 库存 */
	private Integer productStock;

	/** 描述 */
	private String productDescription;

	/** 小图 */
	private String productIcon;

	/** 商品状态,0正常1下架 */
	private Integer productStatus;

	/** 类目编号 */
	private Integer categoryType;

	public ProductInfo() {
		super();
	}

	@Override
	public String toString() {
		return "ProductInfo [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productStock=" + productStock + ", productDescription=" + productDescription + ", productIcon="
				+ productIcon + ", productStatus=" + productStatus + ", categoryType=" + categoryType + "]";
	}

}
