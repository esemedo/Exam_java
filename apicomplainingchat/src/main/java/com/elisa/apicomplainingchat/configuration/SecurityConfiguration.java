package com.elisa.apicomplainingchat.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.elisa.apicomplainingchat.security.AuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	   private  AuthenticationFilter authenticationFilter;

	    public SecurityConfiguration(AuthenticationFilter authenticationFilter) {
	        this.authenticationFilter = authenticationFilter;
	    }
	    @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	      http.csrf(csrf-> csrf.disable())
	          .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
	          .httpBasic(Customizer.withDefaults())
	          .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	          .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
	        return http.build();
	    }
}
