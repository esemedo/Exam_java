package com.elisa.apicomplainingchat.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elisa.apicomplainingchat.exception.QuoteNotFoundException;
import com.elisa.apicomplainingchat.model.Quote;
import com.elisa.apicomplainingchat.service.QuotesService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class QuotesController {
	
	QuotesService quotesService;
	public QuotesController(QuotesService quotesService) {
		this.quotesService = quotesService;
	}
	 @GetMapping("/")
	 public ResponseEntity<String> getHome() {
		 HttpHeaders headers = new HttpHeaders();
	     ResponseEntity<String> entity = new ResponseEntity<>("Hello World",headers,HttpStatus.OK);    
		 return entity;
	 }
	 @GetMapping("/getAllQuotes")
	 public ResponseEntity<List<Quote>> getQuotes() {
		 HttpHeaders headers = new HttpHeaders();
		 List<Quote> allQuotes =quotesService.getQuotes();
		 if(allQuotes.size() ==0 ) {
			 throw new QuoteNotFoundException("Could not find quotes.");
		 }
	     ResponseEntity<List<Quote>> entity = new ResponseEntity<>(allQuotes,headers,HttpStatus.OK);    
		 return entity;
	 }
	 @GetMapping("/getQuote")
	 public ResponseEntity<Quote> getQuote() {
		 HttpHeaders headers = new HttpHeaders();
         Quote oneQuote =quotesService.getOneQuotes();
         if(oneQuote.getQuotes().isBlank()) {
			 throw new QuoteNotFoundException("Could not find a quote.");
		 }
	     ResponseEntity<Quote> entity = new ResponseEntity<>(oneQuote,headers,HttpStatus.OK);    
	     return entity;
	 }
}
