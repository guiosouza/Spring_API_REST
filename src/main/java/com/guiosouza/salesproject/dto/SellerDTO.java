package com.guiosouza.salesproject.dto;

import com.guiosouza.salesproject.projections.SellerProjections;

public class SellerDTO {
	
	private String name;
	private int qtity;
	private Double sum;
	
	public SellerDTO() {
		
	}

	public SellerDTO(String name, int qtity, Double sum) {
		this.name = name;
		this.qtity = qtity;
		this.sum = sum;
	}
	
	public SellerDTO(SellerProjections projection) {
		name = projection.getName();
		qtity = projection.getQtity();
		sum = projection.getSum();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQtity() {
		return qtity;
	}

	public void setQtity(int qtity) {
		this.qtity = qtity;
	}

	public Double getSum() {
		return sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "SellerDTO [name=" + name + ", qtity=" + qtity + ", sum=" + sum + "]";
	}

}
