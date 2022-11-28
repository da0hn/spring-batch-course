package com.gabriel.batch.multiple.format.file.reader;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public final class Client implements ReadableFileData {

  private String name;
  private String surname;
  private String age;
  private String email;
  private Collection<Transaction> transactions = new ArrayList<>();

  public void addTransaction(final Transaction transaction) {
    this.transactions.add(transaction);
  }

}
