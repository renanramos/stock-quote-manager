package com.stockquotemanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockquotemanager.model.Stock;
import com.stockquotemanager.repository.StockRepository;

@Service
public class StockService {

	@Autowired
	private StockRepository stockRepository;
	
	
	public List<Stock> getAllStocksQuote() {
		return stockRepository.getStockQuotes();
	}
	
	public Stock saveNewStock(Stock stock) {
		return stockRepository.save(stock);
	}

	public List<Stock> getStockById(String stockId) {
		return stockRepository.getStockById(stockId);		
	}
}
