package com.guiosouza.salesproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guiosouza.salesproject.entities.Sales;
import com.guiosouza.salesproject.repositories.SalesRepository;

// reconhecer como recurso REST
@RestController
@RequestMapping(value = "/sales") // caminho para requisição
public class SalesResource {
	
	@Autowired
	private SalesRepository salesRepository;
	
	@GetMapping // quando executar uma requsição GET, será chamado o método abaixo
	// dentro do ResponseEntity está o tipo da resposta (lista de vendas)
	public ResponseEntity<List<Sales>> findAll() {
		List<Sales> list = salesRepository.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Sales> findById(@PathVariable Long id) {
		Sales sale = salesRepository.findById(id).get();
		return ResponseEntity.ok().body(sale);
	}
	
}