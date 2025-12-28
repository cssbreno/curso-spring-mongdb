package com.cssbreno.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cssbreno.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

  @GetMapping
  public ResponseEntity<List<User>> findAll() {
    User maria = new User(1, "Maria Brown", "maria@email.com");
    User breno = new User(1, "Breno SIlva", "breno@email.com");
    List<User> list = new ArrayList<>(Arrays.asList(maria, breno));
    return ResponseEntity.ok().body(list);
  }
}
