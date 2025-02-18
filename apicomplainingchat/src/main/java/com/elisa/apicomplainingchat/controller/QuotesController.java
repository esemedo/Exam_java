package com.elisa.apicomplainingchat.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elisa.apicomplainingchat.model.Quote;
import com.elisa.apicomplainingchat.service.QuotesService;

@CrossOrigin(origins = "*")
@RestController
public class QuotesController {
	
	QuotesService quotesService;
	public QuotesController(QuotesService quotesService) {
		this.quotesService = quotesService;
	}
	 @GetMapping("/getAllQuotes")
	 public List<Quote> getQuotes() {
		 return quotesService.getQuotes();
	 }
	 @GetMapping("/getQuote")
	 public Quote getQuote() {
		
		 return quotesService.getOneQuotes();
		 
		 
	 }
}
