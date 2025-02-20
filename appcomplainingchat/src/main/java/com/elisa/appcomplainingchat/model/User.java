package com.elisa.appcomplainingchat.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
@Entity
public class User {
	

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	    private String firstname;
	    private String lastname;

	    @OneToMany(mappedBy = "user")
	    private List<Message> messages;

	    public User() {}

	    public User(String firstname, String lastname) {
	        this.firstname = firstname;
	        this.lastname = lastname;
	    }

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }


	    public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public List<Message> getMessages() {
	        return messages;
	    }

	    public void setMessages(List<Message> messages) {
	        this.messages = messages;
	    }
}
