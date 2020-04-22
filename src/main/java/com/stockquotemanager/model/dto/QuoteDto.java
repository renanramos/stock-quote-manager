package com.stockquotemanager.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.stockquotemanager.model.Quote;

public class QuoteDto {

	private String quoteValue;

	private String quoteDate;	

	public QuoteDto() { }
	
	public QuoteDto(Quote quote) {
		this.quoteDate = quote.getQuoteDate();
		this.quoteValue = quote.getQuoteValue();
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

	@Override
	public String toString() {
		return "QuoteDto [quoteValue=" + quoteValue + ", quoteDate=" + quoteDate + "]";
	}
	
	public static List<QuoteDto> convertQuote(List<Quote> quote) {
		return quote.stream().map(QuoteDto::new).collect(Collectors.toList());
	}
}
