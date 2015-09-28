package com.xformation.model;

import java.io.Serializable;

public class Order implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public Integer oid;
	public String desc;
	public Float price;
	
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
}