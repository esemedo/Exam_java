package com.elisa.appcomplainingchat.model;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Message {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	    private String content;
	    private LocalDateTime date;
	    private String response;

	    @ManyToOne
	    private User user;

	    public Message() {}

	    public Message(String content, LocalDateTime date, User user, String response) {
	        this.content = content;
	        this.date = date;
	        this.user = user;
	        this.response = response;
	    }

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public String getContent() {
	        return content;
	    }

	    public void setContent(String content) {
	        this.content = content;
	    }

	    public LocalDateTime getDate() {
	        return date;
	    }

	    public void setDate(LocalDateTime date) {
	        this.date = date;
	    }

	    public User getUser() {
	        return user;
	    }

	    public void setUser(User user) {
	        this.user = user;
	    }

		public String getResponse() {
			return response;
		}

		public void setResponse(String response) {
			this.response = response;
		}
}
