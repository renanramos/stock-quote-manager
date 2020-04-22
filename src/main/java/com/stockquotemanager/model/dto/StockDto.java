package com.stockquotemanager.model.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.stockquotemanager.model.Quote;
import com.stockquotemanager.model.Stock;

public class StockDto {

	private String id;
	
	private List<QuoteDto> quotes;

	public StockDto() { }
	
	public StockDto(Stock stock) {
		this.id = stock.getId();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<QuoteDto> getQuotes() {
		return quotes;
	}

	public void setQuotes(List<QuoteDto> quotes) {
		this.quotes = quotes;
	}

	@Override
	public String toString() {
		return "StockDto [id=" + id + ", quotes=" + quotes + "]";
	}
	
	public static List<StockDto> converterStockListToStockDtoList(List<Stock> stocks) {
		List<StockDto> stocksDtoList = new ArrayList<>();
		String lastStockId = new String();
		for(int i = 0; i < stocks.size(); i++) {
			StockDto stockDto = new StockDto(stocks.get(i));
			if (!stockDto.getId().equals(lastStockId)) {
				stockDto.setQuotes(QuoteDto.convertQuote(stocks.get(i).getQuotes()));
				stocksDtoList.add(stockDto);				
			}
			lastStockId = stocks.get(i).getId();
		}
		return stocksDtoList;
	}
	
}
