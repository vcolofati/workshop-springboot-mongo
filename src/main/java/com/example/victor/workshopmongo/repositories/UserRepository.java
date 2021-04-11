package com.example.victor.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.victor.workshopmongo.domain.User;

public interface UserRepository extends MongoRepository<User, String> {
	
}
