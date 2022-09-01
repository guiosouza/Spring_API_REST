package com.guiosouza.salesproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guiosouza.salesproject.entities.Sales;


// classe para acessar e manipular dos dados da entidade Sales (CRUD)
@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> { // tipo generics o JPA

}
