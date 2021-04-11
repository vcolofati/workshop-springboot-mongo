package com.example.victor.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.victor.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")

public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		User obj = new User("1", "Maria Brown", "maria@gmail.com");
		User obj2 = new User("2", "Alex Green", "alex@gmail.com");

		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(obj, obj2));
		return ResponseEntity.ok().body(list);
	}
}
