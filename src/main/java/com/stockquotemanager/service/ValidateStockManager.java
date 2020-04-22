package com.stockquotemanager.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.stockquotemanager.constants.StockQuoteConstants;
import com.stockquotemanager.model.StockValidation;

@Service
public class ValidateStockManager {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public boolean validNewStockManager(String stockId) {
		Optional<?> stock = restTemplate.getForObject(StockQuoteConstants.BASE_URL + "/stock/" + stockId, Optional.class);
		
		if (stock != null && stock.isPresent()) {
			return true;
		}
		return false;
	}
	
	public void createNewStockManager(StockValidation stockValidation) {
		ResponseEntity<StockValidation> response = restTemplate.postForEntity(StockQuoteConstants.BASE_URL, stockValidation, StockValidation.class);
		System.out.println(response.getBody());
	}
}
