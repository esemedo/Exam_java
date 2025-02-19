package com.elisa.appcomplainingchat.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.elisa.appcomplainingchat.model.User;
import com.elisa.appcomplainingchat.repository.UserRepository;

@Service
public class UserService {
	UserRepository userRepository ;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	public User findOrCreateUser(String firstname, String lastname) {
		Optional<User> optionalUser = userRepository.findByLastname(lastname);
		return optionalUser.orElseGet(()->userRepository.save(new User(firstname,lastname)));
	}
}
