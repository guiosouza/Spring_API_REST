package com.guiosouza.salesproject;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.guiosouza.salesproject.dto.SellerDTO;
import com.guiosouza.salesproject.entities.Sales;
import com.guiosouza.salesproject.entities.Seller;
import com.guiosouza.salesproject.projections.SellerProjections;
import com.guiosouza.salesproject.repositories.SalesRepository;
import com.guiosouza.salesproject.repositories.SellerRepository;



@SpringBootApplication
public class SalesProjectApplication implements CommandLineRunner { 

	@Autowired
	private SellerRepository sellerRepository; // para usar o CRUD

	@Autowired
	private SalesRepository salesRepository; // para usar o CRUD

	public static void main(String[] args) {
		SpringApplication.run(SalesProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception { // Statar a aplicação e instanciar os dados
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		// Dados inseridos por hard code
		
		// Vendedores
		Seller seller1 = new Seller(null, "Guilherme de Oliveira"); // 
		Seller seller2 = new Seller(null, "Henrique Cintra");
		Seller seller3 = new Seller(null, "José de Assis");

		// Vendas
		Sales v1 = new Sales(null, sdf.parse("12/12/2021"), 1200.00, seller1.getName(), seller1); // null para o banco inserir
		Sales v2 = new Sales(null, sdf.parse("16/12/2021"), 2200.00, seller2.getName(), seller2);
		Sales v3 = new Sales(null, sdf.parse("17/12/2021"), 2200.00, seller1.getName(), seller1);
		Sales v4 = new Sales(null, sdf.parse("26/12/2021"), 2200.00, seller2.getName(), seller2);
		Sales v5 = new Sales(null, sdf.parse("25/12/2021"), 5000.00, seller3.getName(), seller3);

		seller1.getSales().addAll(Arrays.asList(v1, v3)); // adiciona vários elementos ao mesmo tempo
		seller2.getSales().addAll(Arrays.asList(v2, v4));
		seller3.getSales().addAll(Arrays.asList(v5));

		sellerRepository.save(seller1);
		sellerRepository.save(seller2);
		sellerRepository.save(seller3);

		salesRepository.save(v1); // salvando as vendas
		salesRepository.save(v2);
		salesRepository.save(v3);
		salesRepository.save(v4);
		salesRepository.save(v5);
		
		// contador teste
		System.out.println(salesRepository.count());
		
		List<SellerProjections> list1 = sellerRepository.SalesReport(sdf.parse("12/12/2021"), sdf.parse("26/12/2021"));
		List<SellerDTO> result1 = list1.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());

		for (SellerDTO obj: result1) {
			System.out.println(obj);
		}

	}
	


}
