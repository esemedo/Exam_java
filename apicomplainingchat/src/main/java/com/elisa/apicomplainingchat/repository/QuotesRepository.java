package com.elisa.apicomplainingchat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elisa.apicomplainingchat.model.Quote;

@Repository
public interface QuotesRepository extends JpaRepository<Quote, Integer>{

}
