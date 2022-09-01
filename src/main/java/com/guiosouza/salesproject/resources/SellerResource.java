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

//reconhecer como recurso REST
@RestController
@RequestMapping(value = "/sellers") // caminho para requisição pela categoria
public class SellerResource {
	
	@Autowired // facilitar instância do sellerRepository
	private SellerRepository sellerRepository;
	
	@GetMapping // quando executar uma requsição GET, será chamado o método abaixo
	// dentro do ResponseEntity está o tipo da resposta (lista de vendedores)
	public ResponseEntity<List<Seller>> findAll() {
		List<Seller> list = sellerRepository.findAll(); // criar uma lista 
		return ResponseEntity.ok().body(list); // ok() instancia informando que requisição da lista deu certo 
	}


	@GetMapping(value = "/{id}") // quando executar uma requsição GET pelo id do vendedor
	public ResponseEntity<Seller> findById(@PathVariable Long id) { // @PathVariable reconhece o "/{id do vendedor}";
		Seller seller = sellerRepository.findById(id).get(); // .get pega o objeto do optional
		return ResponseEntity.ok().body(seller);
	}
}