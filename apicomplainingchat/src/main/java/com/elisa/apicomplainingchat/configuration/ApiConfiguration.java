package com.elisa.apicomplainingchat.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApiConfiguration {

	@Value("${api.key}")
    private String apiKey;
	
    public String getApiKey() {
        return apiKey;
    }
    
}
