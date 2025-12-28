package com.cssbreno.workshopmongo.domain;

import java.io.Serial;
import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  private int id;
  private String name;
  private String email;


  public User(int id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }

  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    User other = (User) obj;
      return id == other.id;
  }

  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    return result;
  }
}