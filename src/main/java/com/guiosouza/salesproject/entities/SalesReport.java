package com.guiosouza.salesproject.entities;

import com.guiosouza.salesproject.projections.SalesProjections;

public class SalesReport {
	private Double totalValue;
	private Double avgValue;

	public SalesReport() {
		
	}
	
	public SalesReport(Double totalValue, Double avgValue) {
		super();
		this.totalValue = totalValue;
		this.avgValue = avgValue;
	}

	public SalesReport(SalesProjections salesProjections) {
		this.totalValue = salesProjections.getSale_value();
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public Double getAvgValue() {
		return avgValue;
	}

	public void setAvgValue(Double avgValue) {
		this.avgValue = avgValue;
	}

}
