package com.cssbreno.workshopmongo.dto;

import java.io.Serializable;

import com.cssbreno.workshopmongo.domain.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO implements Serializable{

  private String id;
  private String name;
  private String email;

  public UserDTO(User obj){
    this.id = obj.getId();
    this.name = obj.getName();
    this.email = obj.getEmail();
  }
}