package com.example.victor.workshopmongo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.victor.workshopmongo.domain.Post;
import com.example.victor.workshopmongo.domain.User;
import com.example.victor.workshopmongo.dto.AuthorDTO;
import com.example.victor.workshopmongo.dto.CommentDTO;
import com.example.victor.workshopmongo.repositories.PostRepository;
import com.example.victor.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();
		postRepository.deleteAll();

		User maria = new User("Maria Brown", "maria@gmail.com");
		User alex = new User("Alex Green", "alex@gmail.com");
		User bob = new User("Bob Grey", "bob@gmail.com");

		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		Post post1 = new Post(Instant.parse("2018-03-21T19:53:07Z"), "Partiu viagem",
				"Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(Instant.parse("2018-03-23T19:53:07Z"), "Bom dia", "Acordei feliz hoje!",
				new AuthorDTO(maria));

		CommentDTO comment1 = new CommentDTO("Boa viagem mano!", Instant.parse("2018-03-21T19:57:07Z"),
				new AuthorDTO(alex));
		CommentDTO comment2 = new CommentDTO("Aproveite!", Instant.parse("2018-03-22T09:53:07Z"), new AuthorDTO(bob));
		CommentDTO comment3 = new CommentDTO("Tenha um ótimo dia!", Instant.parse("2018-03-23T19:53:07Z"),
				new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(comment1, comment2));
		post2.getComments().add(comment3);

		postRepository.saveAll(Arrays.asList(post1, post2));

		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);

	}

}
