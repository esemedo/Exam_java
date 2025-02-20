package com.elisa.appcomplainingchat.dto;

import java.time.format.DateTimeFormatter;

import com.elisa.appcomplainingchat.model.Message;
import com.elisa.appcomplainingchat.model.User;

public class MessageDTO {
    private String content;
    private String formattedDate;
    private User user;
    private String response;

	public MessageDTO(Message message) {
        this.content = message.getContent();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.formattedDate = message.getDate().format(formatter);
        this.user = message.getUser();
        this.response = message.getResponse();
    }

    // Getters
    public String getContent() {
        return content;
    }

    public String getFormattedDate() {
        return formattedDate;
    }
    public User getUser() {
 		return user;
 	}

 	public String getResponse() {
 		return response;
 	}

 
}