package com.guiosouza.salesproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guiosouza.salesproject.entities.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {

}
