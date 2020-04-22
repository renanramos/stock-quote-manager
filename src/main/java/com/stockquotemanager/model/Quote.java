package com.stockquotemanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Quote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String quoteValue;

	private String quoteDate;	

	@ManyToOne
    @JoinColumn(name = "stock_id_db")
	private Stock stock;

	public Quote() { }
		
	public Quote(String quoteDate, String quoteValue, Stock stock) {
		this.quoteValue = quoteValue;
		this.quoteDate = quoteDate;
		this.stock = stock;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuoteValue() {
		return quoteValue;
	}

	public void setQuoteValue(String quoteValue) {
		this.quoteValue = quoteValue;
	}

	public String getQuoteDate() {
		return quoteDate;
	}

	public void setQuoteDate(String quoteDate) {
		this.quoteDate = quoteDate;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Quote [id=" + id + ", quoteValue=" + quoteValue + ", quoteDate=" + quoteDate + ", stock=" + stock + "]";
	}	
	
}
