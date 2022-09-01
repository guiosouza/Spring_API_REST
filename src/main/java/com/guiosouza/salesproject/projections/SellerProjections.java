package com.guiosouza.salesproject.projections;

public interface SellerProjections {
	
	// somente os campos que quero buscar no banco
	String getName();
	int getQtity();
	Double getAvg();
	Double getSum();
}
