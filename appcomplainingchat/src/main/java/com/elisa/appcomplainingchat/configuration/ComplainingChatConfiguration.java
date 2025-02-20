package com.elisa.appcomplainingchat.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ComplainingChatConfiguration {
		@Value("${api.quote.url}")
	    private String apiQuoteUrl;
		@Value("${api.key}")
	    private String apiKey;
	    @Bean
	    public RestTemplate restTemplate() {
	        return new RestTemplate();
	    }
	    
	    public String getApiQuoteUrl() {
	        return apiQuoteUrl;
	    }
	    public String getApiKey() {
	        return apiKey;
	    }
}
