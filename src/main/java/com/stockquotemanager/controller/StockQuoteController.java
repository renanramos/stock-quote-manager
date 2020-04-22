package com.stockquotemanager.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.stockquotemanager.model.Quote;
import com.stockquotemanager.model.Stock;
import com.stockquotemanager.model.dto.StockDto;
import com.stockquotemanager.model.dto.StockForm;
import com.stockquotemanager.service.QuoteService;
import com.stockquotemanager.service.StockService;
import com.stockquotemanager.service.ValidateStockManager;

@RestController
@RequestMapping("/stock-quote")
public class StockQuoteController {

	@Autowired
	private StockService stockService;
	
	@Autowired
	private QuoteService quoteService;
	
	@Autowired
	private ValidateStockManager validateStockManager;
	
	@GetMapping
	public List<StockDto> getAllStocks() {
		List<Stock> stocks = stockService.getAllStocksQuote();
		return StockDto.converterStockListToStockDtoList(stocks);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<StockDto> createStockQuote(@RequestBody StockForm stockForm, UriComponentsBuilder uriBuilder) {
		
		boolean isStockIdAvailable = validateStockManager.validNewStockManager(stockForm.getId());
		
		if (isStockIdAvailable) {
			Stock stock = new Stock();
			stock.setId(stockForm.getId());
			stock = stockService.saveNewStock(stock);
			List<Quote> quotes = stockForm.convertLinkedHasMapToQuoteDtoList(stockForm, stock);
			quoteService.saveQuotes(quotes);
			
			stock.setQuotes(quotes);
			URI uri = uriBuilder.path("/stock-quote/{id}").buildAndExpand(stock.getId()).encode().toUri();
			return ResponseEntity.created(uri).body(new StockDto(stock));
		}
		return ResponseEntity.unprocessableEntity().build();
	}
	
	@GetMapping("/{id}")
	public List<StockDto> getStockById(@PathVariable("id") String stockId) {
		List<Stock> stock = stockService.getStockById(stockId);
		return StockDto.converterStockListToStockDtoList(stock);
	}
}
