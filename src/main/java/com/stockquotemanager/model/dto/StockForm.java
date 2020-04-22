package com.stockquotemanager.model.dto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.stockquotemanager.model.Quote;
import com.stockquotemanager.model.Stock;

public class StockForm {

	private String id;
	private LinkedHashMap<String, String> quotes;
	
	public StockForm() { }

	public StockForm(String id, LinkedHashMap<String, String> quotes) {
		this.id = id;
		this.quotes = quotes;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LinkedHashMap<String, String> getQuotes() {
		return quotes;
	}

	public void setQuotes(LinkedHashMap<String, String> quotes) {
		this.quotes = quotes;
	}

	public List<Quote> convertLinkedHasMapToQuoteDtoList(StockForm stockForm, Stock stock) {
		LinkedHashMap<String, String> quotesMap = new LinkedHashMap<String, String>();
		quotesMap = stockForm.getQuotes();
		List<Quote> quotesList = new ArrayList<Quote>();
		for (String key: quotesMap.keySet()) {
			Quote quote = new Quote(key, quotesMap.get(key), stock);
			quotesList.add(quote);
		}
		
		System.out.println(quotesList.size());
		return quotesList;
	}
}
