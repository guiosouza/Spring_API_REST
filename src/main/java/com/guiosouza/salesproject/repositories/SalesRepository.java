package com.guiosouza.salesproject.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.guiosouza.salesproject.entities.Sales;
import com.guiosouza.salesproject.projections.SalesProjections;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long>{
	// buscar vendas do seller para tirar média
	@Query(nativeQuery = true, value = "SELECT SELLER_NAME, COUNT(*) AS QTD, SUM(CAST(SALE_VALUE AS NUMERIC(15,2))) AS TOTAL_VALUE "
			+ "FROM SALES "
			+ "WHERE CAST(SALE_DATE AS DATE) BETWEEN (:initialDate) AND (:finalDate) GROUP BY SELLER_NAME")
	List<SalesProjections> findBySales(Date initialDate, Date finalDate);

}
