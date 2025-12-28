package com.cssbreno.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cssbreno.workshopmongo.domain.User;
import com.cssbreno.workshopmongo.dto.UserDTO;
import com.cssbreno.workshopmongo.services.UserService;


@RestController //indica que a classe é um recurso web implementado por um controlador REST (diz que essa classe vai atender requisições REST)
@RequestMapping(value = "/users") //mapeia esse recurso web para o caminho /users (caminho para acessar esse recurso)
public class UserResource {

  @Autowired
  private UserService service;

  @GetMapping //mapeia requisições do tipo GET
  public ResponseEntity<List<UserDTO>> findAll() {
    List<UserDTO> listDTO =
        service.findAll().stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
    return ResponseEntity.ok().body(listDTO); //retorna uma resposta HTTP com o status 200 (OK) e o corpo contendo a lista de usuários
  }

  @GetMapping(value = "/{id}") //mapeia requisições do tipo GET para o caminho /users/{id}, onde {id} é um parâmetro de caminho
  public ResponseEntity<UserDTO> findById(@PathVariable String id) {
    User obj = service.findById(id); //obtém o ID do usuário a partir do parâmetro de caminho e chama o serviço para buscar o usuário correspondente
    return ResponseEntity.ok().body(new UserDTO(obj)); //retorna uma resposta HTTP com o status 200 (OK) e o corpo contendo o usuário encontrado
  }
}