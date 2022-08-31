package com.guiosouza.salesproject;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.guiosouza.salesproject.entities.Sales;
import com.guiosouza.salesproject.entities.Seller;
import com.guiosouza.salesproject.projections.SalesProjections;
import com.guiosouza.salesproject.repositories.SalesRepository;
import com.guiosouza.salesproject.repositories.SellerRepository;

@SpringBootApplication
public class SalesProjectApplication implements CommandLineRunner {

	@Autowired
	private SellerRepository sellerRepository;

	@Autowired
	private SalesRepository salesRepository;

	public static void main(String[] args) {
		SpringApplication.run(SalesProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Seller seller1 = new Seller(null, "Guilherme de Oliveira");
		Seller seller2 = new Seller(null, "Henrique Cintra");
		Seller seller3 = new Seller(null, "José de Assis");

		Sales v1 = new Sales(null, sdf.parse("12/12/2021"), 1200.00, seller1.getName(), seller1);
		Sales v2 = new Sales(null, sdf.parse("16/12/2021"), 2200.00, seller2.getName(), seller2);
		Sales v3 = new Sales(null, sdf.parse("17/12/2021"), 2200.00, seller1.getName(), seller1);
		Sales v4 = new Sales(null, sdf.parse("26/12/2021"), 2200.00, seller2.getName(), seller2);

		seller1.getSales().addAll(Arrays.asList(v1, v3));
		seller2.getSales().addAll(Arrays.asList(v2, v4));

		sellerRepository.save(seller1);
		sellerRepository.save(seller2);
		sellerRepository.save(seller3);

		salesRepository.save(v1);
		salesRepository.save(v2);
		salesRepository.save(v3);
		salesRepository.save(v4);
		
		// contador teste
		System.out.println(salesRepository.count());
		
		List<SalesProjections> list1 = salesRepository.findBySales(sdf.parse("12/12/2021"), sdf.parse("17/12/2021"));

		
		for (SalesProjections obj: list1) {
			System.out.println(obj);
		}

	}
	


}
