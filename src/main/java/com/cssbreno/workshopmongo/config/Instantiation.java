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

    User joel = new User(null, "Joel Miller", "joel@theguardians.com");
    User ellie = new User(null, "Ellie Williams", "ellie@theinfected.com");
    User tess = new User(null, "Tess", "tess@theguardians.com");

    userRepository.saveAll(Arrays.asList(joel, ellie, tess));
  }

}
