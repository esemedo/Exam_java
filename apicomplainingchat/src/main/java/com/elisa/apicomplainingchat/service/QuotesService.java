package com.elisa.apicomplainingchat.service;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.elisa.apicomplainingchat.model.Quote;
import com.elisa.apicomplainingchat.repository.QuotesRepository;

@Service
public class QuotesService {
	QuotesRepository quotesRepository ;
	
	public QuotesService(QuotesRepository quotesRepository) {
		this.quotesRepository = quotesRepository;
	}
	
	public List<Quote> getQuotes(){
		return this.quotesRepository.findAll();
	}
	public Quote getOneQuotes(){
			Random r = new Random();
			List<Quote> quotes =  this.quotesRepository.findAll();
			int index = 0;	
			if(quotes.size() > 0) {
				index = r.nextInt(quotes.size());
				return quotes.get(index);
			}
			return new Quote("");
	}
	
}
