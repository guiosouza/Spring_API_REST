package com.guiosouza.salesproject.dto;

import java.text.DecimalFormat;

import com.guiosouza.salesproject.projections.SellerProjections;

public class SellerDTO {
	
	private String name;
	private int qtity;
	private Double avg;
	private Double sum;
	
	public SellerDTO() {
		
	}

	public SellerDTO(String name, int qtity, Double avg, Double sum) {
		this.name = name;
		this.qtity = qtity;
		this.avg = avg;
		this.sum = sum;
	}
	
	public SellerDTO(SellerProjections projection) {
		name = projection.getName();
		qtity = projection.getQtity();
		sum = projection.getSum();
		avg = projection.getAvg();
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

	public Double getAvg() {
		return avg;
	}

	public void setAvg(Double avg) {
		this.avg = avg;
	}

	public Double getSum() {
		return sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "SellerReport [Nome: " + name 
				+ ", Qtd de vendas: " 
				+ qtity + ", Média diária: " + new DecimalFormat(".##").format(avg) 
				+ ", Total: " + sum + "]";
	}

}
