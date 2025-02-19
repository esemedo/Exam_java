package com.elisa.appcomplainingchat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elisa.appcomplainingchat.model.Message;
import com.elisa.appcomplainingchat.model.User;
@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>{
	List<Message>findByUser(User user);
}
