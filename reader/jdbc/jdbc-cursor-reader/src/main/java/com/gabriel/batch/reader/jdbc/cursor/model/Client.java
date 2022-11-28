package com.gabriel.batch.reader.jdbc.cursor.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Client {

  private String name;
  private String surname;
  private String age;
  private String email;

}
