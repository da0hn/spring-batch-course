package com.gabriel.batch.multiple.files.reader.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public final class Transaction implements ReadableFileData {

  private String id;
  private String name;
  private String value;

}
