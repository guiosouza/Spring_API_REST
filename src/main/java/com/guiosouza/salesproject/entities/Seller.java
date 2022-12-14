package com.guiosouza.salesproject.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity // entidade gerenciada pelo JPA
public class Seller implements Serializable {
	// Serializable converter objeto java em bites
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Id auto incrementável no banco de dados	
	private Long id; // 
	private String name;
	
	@JsonIgnore // não ficar serializando em loop
	@OneToMany(mappedBy = "seller") // um seller para várias vendas na tabela de vendas
	private List<Sales> sales = new ArrayList<>(); 
	
	public Seller () {
		
	}

	public Seller(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Sales> getSales() {
		return sales;
	}
	
	// HashCode Equals é para um critério personalizado de comparação 

	// comparar dois sellers por id
	@Override
	public int hashCode() { // comparar por código
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) { // garantir comparação
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seller other = (Seller) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
