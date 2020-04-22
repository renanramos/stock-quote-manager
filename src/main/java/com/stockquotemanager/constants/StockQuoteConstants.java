package com.stockquotemanager.constants;

public class StockQuoteConstants {

	public static final String BASE_URL = "http://localhost:8080";
	public static final String GET_ALL_STOCKS_QUOTES = "FROM Stock s LEFT OUTER JOIN Quote q ON (s.idDb = q.stock)";
	public static final String GET_STOCK_QUOTE_BY_ID = "FROM Stock s LEFT OUTER JOIN Quote q ON (s.idDb = q.stock) WHERE s.id = :stockId";
	
}
