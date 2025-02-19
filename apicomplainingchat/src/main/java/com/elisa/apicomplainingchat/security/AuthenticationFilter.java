package com.elisa.apicomplainingchat.security;


import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.elisa.apicomplainingchat.configuration.ApiConfiguration;
import com.elisa.apicomplainingchat.dto.ErrorResponseDTO;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@Component
public class AuthenticationFilter extends OncePerRequestFilter {
	  private ApiConfiguration apiConfiguration;
	  public AuthenticationFilter(ApiConfiguration apiConfiguration) {
		  this.apiConfiguration = apiConfiguration;
	  }

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String requestApiKey = request.getHeader("X-API-KEY"); 
        if (requestApiKey == null || !requestApiKey.equals(apiConfiguration.getApiKey())) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            ErrorResponseDTO errorResponse = new ErrorResponseDTO(LocalDateTime.now(), "Clé API invalide", HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write(errorResponse.toJson());
            return;
        }

        PreAuthenticatedAuthenticationToken authentication =
                new PreAuthenticatedAuthenticationToken(requestApiKey, null, null);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        filterChain.doFilter(request, response);
		
	}
}




