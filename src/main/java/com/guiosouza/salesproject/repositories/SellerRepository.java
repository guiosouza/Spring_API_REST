package com.guiosouza.salesproject.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.guiosouza.salesproject.entities.Seller;
import com.guiosouza.salesproject.projections.SellerProjections;

//classe para acessar e manipular dos dados da entidade Sales (CRUD)
@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {	// tipo generics o JPA
	// query atualizada com média de vendas diárias do seller para soma total
	@Query(nativeQuery = true, value = "SELECT NAME, COUNT(*) AS qtity, "
			+ "SUM(CAST(SALE_VALUE AS NUMERIC(15,2))) / (DATEDIFF(day,  (:initialDate), (:finalDate))) as avg, "
			+ "SUM(CAST(SALE_VALUE AS NUMERIC(15,2))) as SUM\n"
			+ "FROM SALES WHERE CAST(SALE_DATE AS DATE) BETWEEN (:initialDate) AND (:finalDate)"
			+ "GROUP BY name")
	List<SellerProjections> SalesReport(Date initialDate, Date finalDate);
	
}
