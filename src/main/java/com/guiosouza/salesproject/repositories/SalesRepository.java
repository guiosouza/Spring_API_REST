package com.guiosouza.salesproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guiosouza.salesproject.entities.Sales;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long>{

}
