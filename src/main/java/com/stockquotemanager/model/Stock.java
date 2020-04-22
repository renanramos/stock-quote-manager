package com.stockquotemanager.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDb;

	private String id;
	
	@OneToMany(mappedBy = "stock")
	private List<Quote> quotes = new ArrayList<>();
	
	public Stock() {}
	
	public Long getIdDb() {
		return idDb;
	}

	public void setIdDb(Long idDb) {
		this.idDb = idDb;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Quote> getQuotes() {
		return quotes;
	}

	public void setQuotes(List<Quote> quotes) {
		this.quotes = quotes;
	}

	@Override
	public String toString() {
		return "Stock [idDb=" + idDb + ", id=" + id + ", quotesSize= " + quotes.size()  + "]";
	}
	
	
}
