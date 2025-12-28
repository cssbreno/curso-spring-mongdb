package com.cssbreno.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cssbreno.workshopmongo.domain.User;
import com.cssbreno.workshopmongo.repository.UserRepository;

@Service
public class UserService {

  @Autowired //Procura uma instancia dessa interface e injeta aqui automaticamente. Equivale ao new (nesse caso, o Spring Data cria uma implementação dessa interface automaticamente)
  private UserRepository repository;

  public List<User> findAll() {
    return repository.findAll();
  }
}
