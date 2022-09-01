package com.guiosouza.salesproject.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.guiosouza.salesproject.entities.Seller;
import com.guiosouza.salesproject.projections.SellerProjections;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
	// buscar vendas do seller para tirar média
	@Query(nativeQuery = true, value = "SELECT NAME, COUNT(*) AS qtity, SUM(CAST(SALE_VALUE AS NUMERIC(15,2))) AS SUM "
			+ "FROM SALES "
			+ "WHERE CAST(SALE_DATE AS DATE) BETWEEN (:initialDate) AND (:finalDate) GROUP BY name")
	List<SellerProjections> findBySales(Date initialDate, Date finalDate);
}
