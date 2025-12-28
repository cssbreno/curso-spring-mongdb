package com.cssbreno.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cssbreno.workshopmongo.dto.UserDTO;
import com.cssbreno.workshopmongo.services.UserService;

@RestController //indica que a classe é um recurso web implementado por um controlador REST (diz que essa classe vai atender requisições REST)
@RequestMapping(value = "/users") //mapeia esse recurso web para o caminho /users (caminho para acessar esse recurso)
public class UserResource {

  @Autowired
  private UserService service;

  @GetMapping //mapeia requisições do tipo GET
  public ResponseEntity<List<UserDTO>> findAll() {
    List <UserDTO> listDTO = service.findAll().stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
    return ResponseEntity.ok().body(listDTO); //retorna uma resposta HTTP com o status 200 (OK) e o corpo contendo a lista de usuários
  }
}
