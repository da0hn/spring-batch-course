package com.gabriel.batch.multiple.format.file.reader.jobs.steps.readers;

import com.gabriel.batch.multiple.format.file.reader.Client;
import com.gabriel.batch.multiple.format.file.reader.ReadableFileData;
import com.gabriel.batch.multiple.format.file.reader.Transaction;
import lombok.SneakyThrows;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;

public class ClientTransactionReader implements ItemStreamReader<Client> {

  private final ItemStreamReader<? extends ReadableFileData> delegate;
  private Object currentObject;

  public ClientTransactionReader(final ItemStreamReader<? extends ReadableFileData> delegate) {this.delegate =
    delegate;}

  @Override
  public Client read() throws Exception {
    if (this.currentObject == null) {
      this.currentObject = this.delegate.read();
    }
    final var client = (Client) this.currentObject;
    if (client != null) {
      while (this.peek() instanceof Transaction transaction) {
        client.addTransaction(transaction);
      }
    }
    return client;
  }

  @SneakyThrows
  private Object peek() {
    this.currentObject = this.delegate.read();
    return this.currentObject;
  }

  @Override
  public void open(final ExecutionContext executionContext) throws ItemStreamException {
    this.delegate.open(executionContext);
  }

  @Override
  public void update(final ExecutionContext executionContext) throws ItemStreamException {
    this.delegate.update(executionContext);
  }

  @Override
  public void close() throws ItemStreamException {
    this.delegate.close();
  }

}
