package com.cssbreno.workshopmongo.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cssbreno.workshopmongo.domain.User;

@Repository //indica que essa interface é um repositório do Spring Data (componente responsável por acessar o banco de dados)
public interface UserRepository extends MongoRepository<User, String>{

}
