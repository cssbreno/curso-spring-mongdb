package com.cssbreno.workshopmongo.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cssbreno.workshopmongo.domain.User;
import com.cssbreno.workshopmongo.repository.UserRepository;
import com.cssbreno.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

  @Autowired //Procura uma instancia dessa interface e injeta aqui automaticamente. Equivale ao new (nesse caso, o Spring Data cria uma implementação dessa interface automaticamente)
  private UserRepository repository;

  public List<User> findAll() {
    return repository.findAll(); //chama o método findAll() do UserRepository que retorna todos os usuários do banco de dados
  }

  public User findById(String id) {
    Optional<User> obj = repository.findById(id); //retorna um Optional que pode ou não conter um usuário com o ID fornecido
    return obj.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado")); //se o usuário não for encontrado, lança uma exceção personalizada
  }
}
