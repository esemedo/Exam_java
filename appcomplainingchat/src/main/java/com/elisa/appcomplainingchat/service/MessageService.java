package com.elisa.appcomplainingchat.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
		List<MessageDTO> messageDTOs = new ArrayList<>();
		for (Message message : allMessages) {
		    messageDTOs.add(new MessageDTO(message));
		}
		 return messageDTOs;
	}
}
