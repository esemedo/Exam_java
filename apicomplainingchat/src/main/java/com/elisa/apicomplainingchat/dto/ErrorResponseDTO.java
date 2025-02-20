package com.elisa.apicomplainingchat.dto;

import java.time.LocalDateTime;

public class ErrorResponseDTO {

	    private LocalDateTime timestamp;
	    private String message;
	    private int status;

	    public ErrorResponseDTO(LocalDateTime timestamp, String message, int status) {
	        this.timestamp = timestamp;
	        this.message = message;
	        this.status = status;
	    }

	    public LocalDateTime getTimestamp() {
	        return timestamp;
	    }

	    public String getMessage() {
	        return message;
	    }

	    public int getStatus() {
	        return status;
	    }
	    public String toJson() {
	        return "{"
	                + "\"timestamp\": \"" + timestamp + "\","
	                + "\"message\": \"" + message + "\","
	                + "\"status\": " + status
	                + "}";
	    }
}
