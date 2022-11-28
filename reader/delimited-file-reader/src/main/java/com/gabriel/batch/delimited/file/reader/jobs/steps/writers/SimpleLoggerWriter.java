package com.gabriel.batch.delimited.file.reader.jobs.steps.writers;

import com.gabriel.batch.delimited.file.reader.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Slf4j
public class SimpleLoggerWriter implements ItemWriter<Client> {

  @Override
  public void write(final List<? extends Client> items) throws Exception {
    items.forEach(item -> log.info("data -> {}", item));
  }

}
