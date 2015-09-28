package com.xformation.model;

public class Drink extends Product {
	
	private static final long serialVersionUID = 1L;
	
	Boolean hasIce;
	Boolean hasLemon;
	
	public Boolean getHasIce() {
		return hasIce;
	}
	public void setHasIce(Boolean hasIce) {
		this.hasIce = hasIce;
	}
	public Boolean getHasLemon() {
		return hasLemon;
	}
	public void setHasLemon(Boolean hasLemon) {
		this.hasLemon = hasLemon;
	}
	
}