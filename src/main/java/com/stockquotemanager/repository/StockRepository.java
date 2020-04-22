package com.stockquotemanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stockquotemanager.constants.StockQuoteConstants;
import com.stockquotemanager.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {
	
	@Query(StockQuoteConstants.GET_ALL_STOCKS_QUOTES)
	List<Stock> getStockQuotes();
	
	@Query(StockQuoteConstants.GET_STOCK_QUOTE_BY_ID)
	List<Stock> getStockById(@Param("stockId") String stockId);
}
