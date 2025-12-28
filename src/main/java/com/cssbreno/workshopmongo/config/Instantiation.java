package com.cssbreno.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.cssbreno.workshopmongo.domain.User;
import com.cssbreno.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

  @Autowired
  private UserRepository userRepository;

  @Override
  public void run(String... args) throws Exception {

    userRepository.deleteAll();

    User bruna = new User(null, "Bruna Caetano", "bruna@gmail.com");
    User brenda = new User(null, "Brenda Silva", "brenda@gmail.com");
    User maya = new User(null, "Maya Caetano", "chulapet@gmail.com");

    userRepository.saveAll(Arrays.asList(bruna, brenda, maya));
  }

}
