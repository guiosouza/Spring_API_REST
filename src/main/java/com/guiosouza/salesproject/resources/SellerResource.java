package com.guiosouza.salesproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guiosouza.salesproject.entities.Seller;
import com.guiosouza.salesproject.repositories.SellerRepository;

@RestController
@RequestMapping(value = "/categories")
public class SellerResource {
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@GetMapping
	public ResponseEntity<List<Seller>> findAll() {
		List<Seller> list = sellerRepository.findAll();
		return ResponseEntity.ok().body(list);
	}


	@GetMapping(value = "/{id}")
	public ResponseEntity<Seller> findById(@PathVariable Long id) {
		Seller seller = sellerRepository.findById(id).get();
		return ResponseEntity.ok().body(seller);
	}
}