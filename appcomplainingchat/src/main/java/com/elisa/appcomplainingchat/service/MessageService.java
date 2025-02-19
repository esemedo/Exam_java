package com.elisa.appcomplainingchat.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.elisa.appcomplainingchat.dto.MessageDTO;
import com.elisa.appcomplainingchat.model.Message;
import com.elisa.appcomplainingchat.model.User;
import com.elisa.appcomplainingchat.repository.MessageRepository;


@Service
public class MessageService {
	MessageRepository messageRepository;
	public MessageService( MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}
	
	public void saveMessage(String message, User user,String  response) {
        LocalDateTime date = LocalDateTime.now();
        if(!message.isEmpty() && !message.isBlank()) {
        	this.messageRepository.save(new Message(message, date, user, response));
        }
	}
	public List<MessageDTO> findMessagesByUser(User user){
		List<Message> allMessages = this.messageRepository.findByUser(user);
	
		 return allMessages.stream()
                 .map(MessageDTO::new) 
                 .collect(Collectors.toList());
	}
}
