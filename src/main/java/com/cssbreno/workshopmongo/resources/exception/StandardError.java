package com.cssbreno.workshopmongo.resources.exception;

import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StandardError implements Serializable {
  private static final long serialVersionUID = 1L; //identificador de versão da classe para fins de serialização

  private Long timestamp;
  private Integer status;
  private String error;
  private String message;
  private String path;

  //Construtor com todos os atributos para facilitar a criação de objetos StandardError para respostas de erro
  public StandardError(Long timestamp, Integer status, String error, String message, String path) {
    this.timestamp = timestamp;
    this.status = status;
    this.error = error;
    this.message = message;
    this.path = path;
  }
}
