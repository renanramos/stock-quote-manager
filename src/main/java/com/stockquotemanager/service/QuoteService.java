package com.stockquotemanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockquotemanager.model.Quote;
import com.stockquotemanager.repository.QuoteRepository;

@Service
public class QuoteService {

	@Autowired
	private QuoteRepository quoteRepository;
	
	
	public List<Quote> saveQuotes(List<Quote> quotes) {
		return quoteRepository.saveAll(quotes);
	}
}
