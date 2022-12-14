package com.guiosouza.salesproject.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity // entidade gerenciada pelo JPA
public class Sales implements Serializable {
	/* CLASS MUST HAVE
	 * - sale ID
	 * - Date of sale
	 * - sale value
	 * - seller id
	 * - seller name 
	 */
	private static final long serialVersionUID = 1L;
	@Id // notation para id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Id auto incrementável no banco de dados
	private Long id;
	private Date sale_date;
	private Double sale_value;
	private String name;
	
	
	@ManyToOne // muitas vendas para 1 seller somente
	@JoinColumn(name = "seller_id") // chave estrangeira na tabela de vendas
	private Seller seller;
	
	public Sales() {
		
	}

	public Sales(Long id, Date sale_date, Double sale_value, String name, Seller seller) {
		super();
		this.id = id;
		this.sale_date = sale_date;
		this.sale_value = sale_value;
		this.name = seller.getName();
		this.seller = seller;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getSale_date() {
		return sale_date;
	}

	public void setSale_date(Date sale_date) {
		this.sale_date = sale_date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSale_value() {
		return sale_value;
	}

	public void setSale_value(Double sale_value) {
		this.sale_value = sale_value;
	}
	

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sales other = (Sales) obj;
		return Objects.equals(id, other.id);
	}	
}
