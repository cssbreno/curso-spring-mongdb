package com.cssbreno.workshopmongo.domain;

import java.io.Serial;
import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "user") //indica que essa classe é um documento do MongoDB e mapeia essa classe para a coleção "user" no banco de dados
//Caso eu não coloque o nome da coleção, o Spring Data MongoDB usa o nome da classe em minúsculo como nome da coleção
@Getter //gera os métodos getters automaticamente
@Setter //gera os métodos setters automaticamente
@NoArgsConstructor //gera o construtor sem argumentos automaticamente
public class User implements Serializable {
  @Serial //indica a versão da classe para fins de serialização
  private static final long serialVersionUID = 1L;

  @Id //indica que esse atributo é o identificador único do documento no MongoDB
  private String id;
  private String name;
  private String email;


  public User(String id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }

  public boolean equals(Object obj) {
    // verifica se os objetos são iguais com base no id
    if (this == obj)
      return true;
    // verifica se o objeto é nulo ou de classe diferente
    if (obj == null)
      return false;
    // verifica se as classes dos objetos são diferentes
    if (getClass() != obj.getClass())
      return false;
    //verifica se os ids são iguais
    User other = (User) obj;
      return id == other.id;
  }

  public int hashCode() {
    //gera um código hash para o objeto com base no id
    final int prime = 31;
    int result = 1;
    //calcula o código hash usando o id
    result = prime * result + id.hashCode();
    return result;
  }
}