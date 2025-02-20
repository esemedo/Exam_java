package com.elisa.appcomplainingchat.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elisa.appcomplainingchat.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByLastname(String lastname);
	List<User> findByMessagesIsNotNull();
}
