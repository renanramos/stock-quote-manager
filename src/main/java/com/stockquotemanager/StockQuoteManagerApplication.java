package com.stockquotemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.client.RestTemplate;

import com.stockquotemanager.constants.StockQuoteConstants;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableSwagger2
public class StockQuoteManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockQuoteManagerApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {

		RestTemplate restTemplate = new RestTemplateBuilder()
					.rootUri(StockQuoteConstants.BASE_URL)
					.build();
		
		return restTemplate;
	}
	
}

