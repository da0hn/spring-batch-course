package com.gabriel.batch.multiple.format.file.reader;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public final class Client {

  private String name;
  private String surname;
  private String age;
  private String email;

  @Override
  public int hashCode() {
    return Objects.hash(this.name, this.surname, this.age, this.email);
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (obj == null || obj.getClass() != this.getClass()) return false;
    final var that = (Client) obj;
    return Objects.equals(this.name, that.name) &&
           Objects.equals(this.surname, that.surname) &&
           Objects.equals(this.age, that.age) &&
           Objects.equals(this.email, that.email);
  }

  @Override
  public String toString() {
    return "Client[" +
           "name=" + this.name + ", " +
           "surname=" + this.surname + ", " +
           "age=" + this.age + ", " +
           "email=" + this.email + ']';
  }

}
