package com.elisa.apicomplainingchat.controller;
import java.time.LocalDateTime;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.elisa.apicomplainingchat.dto.ErrorResponseDTO;
import com.elisa.apicomplainingchat.exception.QuoteNotFoundException;

@RestControllerAdvice
public class ExceptionController {

	   @ExceptionHandler({DataIntegrityViolationException.class})
	   @ResponseStatus(HttpStatus.UNAUTHORIZED)
	   public ResponseEntity<ErrorResponseDTO>  handleAccessUnauthorizedException(Exception ex) {
		   ErrorResponseDTO error = new ErrorResponseDTO(LocalDateTime.now(), ex.getMessage(), HttpStatus.UNAUTHORIZED.value());
		   return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
	   }
	   
	   //Not found quotes
	   @ExceptionHandler(QuoteNotFoundException.class)
	    public ResponseEntity<ErrorResponseDTO> handleResourceNotFoundException(QuoteNotFoundException ex) {
		   ErrorResponseDTO error = new ErrorResponseDTO(LocalDateTime.now(), ex.getMessage(), HttpStatus.NOT_FOUND.value());
	        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	    }
	   
	   //Not found URL
	   @ExceptionHandler(NoHandlerFoundException.class)
	    public ResponseEntity<ErrorResponseDTO> handleNotFoundException(NoHandlerFoundException ex) {
		   ErrorResponseDTO error = new ErrorResponseDTO(
	            LocalDateTime.now(),
	            "La route demandée n'existe pas.",
	            404
	        );
	        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	    }
	   
	   //Internal server error
	   @ExceptionHandler(Exception.class)
	    public ResponseEntity<ErrorResponseDTO> handleInternalErrorException(Exception ex) {
		   ErrorResponseDTO error = new ErrorResponseDTO(
	            LocalDateTime.now(),
	            "Problème côté serveur.",
	            500
	        );
	        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
}
