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



@Entity
public class Sales implements Serializable {
	/* CLASS MUST HAVE
	 * - sale ID
	 * - Date of sale
	 * - sale value
	 * - seller id
	 * - seller name 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date sale_date;
	private Double sale_value;
	private String seller_name;
	
	
	@ManyToOne
	@JoinColumn(name = "seller_id") // foreign key to show in table
	private Seller seller;
	
	public Sales() {
		
	}

	public Sales(Long id, Date sale_date, Double sale_value, String seller_name, Seller seller) {
		super();
		this.id = id;
		this.sale_date = sale_date;
		this.sale_value = sale_value;
		this.seller_name = seller.getName();
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

	public String getSeller_name() {
		return seller_name;
	}

	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
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

	@Override
	public String toString() {
		return "Sales [sale_value=" + sale_value + "]";
	}
	
	
}
