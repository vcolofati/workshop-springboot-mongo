package com.example.victor.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.victor.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {
	
}
