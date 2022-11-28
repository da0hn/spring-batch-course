package com.gabriel.batch.multiple.format.file.reader;

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
public class Transaction implements RawFileData {

  private String id;
  private String name;
  private String value;

}
