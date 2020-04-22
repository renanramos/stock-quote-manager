package com.stockquotemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockquotemanager.model.Quote;

public interface QuoteRepository extends JpaRepository<Quote, Long>{

}
