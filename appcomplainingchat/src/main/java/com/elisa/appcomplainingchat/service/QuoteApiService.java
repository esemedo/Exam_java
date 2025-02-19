package com.elisa.appcomplainingchat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.elisa.appcomplainingchat.configuration.ComplainingChatConfiguration;
import com.elisa.appcomplainingchat.dto.Quote;

@Service
public class QuoteApiService {
    private RestTemplate restTemplate;
    private String urlApiQuote;
    @Autowired
    private ComplainingChatConfiguration complainingChatConfiguration;
    public QuoteApiService(ComplainingChatConfiguration config) {
    	this.restTemplate = config.restTemplate();
    	this.urlApiQuote = config.getApiQuoteUrl(); 
    }
    public Quote getQuote() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.set("X-API-KEY", complainingChatConfiguration.getApiKey());
        String url = this.urlApiQuote + "/getQuote";
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<Quote> response = restTemplate.exchange(
            url, HttpMethod.GET, requestEntity, Quote.class);
        return response.getBody();
    }
}
