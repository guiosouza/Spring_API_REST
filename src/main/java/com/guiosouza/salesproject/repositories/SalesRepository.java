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
	@Query(nativeQuery = true, value = "SELECT * FROM SALES\r\n"
			+ "WHERE SALE_DATE  BETWEEN (:initialDate) AND (:finalDate);")
	List<SalesProjections> findNumbersOfSales(Date initialDate, Date finalDate);

}
