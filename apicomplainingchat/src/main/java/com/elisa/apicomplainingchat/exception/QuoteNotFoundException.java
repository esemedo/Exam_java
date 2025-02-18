package com.elisa.apicomplainingchat.exception;

public class QuoteNotFoundException extends RuntimeException {

	QuoteNotFoundException() {
	    super("Could not find quote.");
	}

}
