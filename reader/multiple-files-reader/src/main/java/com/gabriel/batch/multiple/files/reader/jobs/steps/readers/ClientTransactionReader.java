package com.gabriel.batch.multiple.files.reader.jobs.steps.readers;

import com.gabriel.batch.multiple.files.reader.model.Client;
import com.gabriel.batch.multiple.files.reader.model.ReadableFileData;
import com.gabriel.batch.multiple.files.reader.model.Transaction;
import lombok.SneakyThrows;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.ResourceAwareItemReaderItemStream;
import org.springframework.core.io.Resource;

public class ClientTransactionReader implements ItemStreamReader<Client>, ResourceAwareItemReaderItemStream<Client> {

  private final FlatFileItemReader<? extends ReadableFileData> delegate;
  private Object currentObject;

  public ClientTransactionReader(final FlatFileItemReader<? extends ReadableFileData> delegate) {
    this.delegate = delegate;
  }

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

  @Override
  public void setResource(final Resource resource) {
    this.delegate.setResource(resource);
  }

}
