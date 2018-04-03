package com.facelay.girls.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * @author facelay
 * @date 2018年3月31日 下午1:41:45
 * @version 1.0
 */
@Entity
public class Girl {

	@Id
	@GeneratedValue
	private Integer id;

	private String cupSize;

	@Min(value = 18, message = "未成年少女禁止插入")
	private Integer age;

	@NotNull(message = "金额必传")
	private Double money;

	public Girl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Girl [id=" + id + ", cupSize=" + cupSize + ", age=" + age + ", money=" + money + "]";
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCupSize() {
		return cupSize;
	}

	public void setCupSize(String cupSize) {
		this.cupSize = cupSize;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
