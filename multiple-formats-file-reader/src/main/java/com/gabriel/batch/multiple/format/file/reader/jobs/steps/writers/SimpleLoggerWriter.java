package com.gabriel.batch.multiple.format.file.reader.jobs.steps.writers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Slf4j
public class SimpleLoggerWriter implements ItemWriter<Object> {

  @Override
  public void write(final List<? extends Object> items) throws Exception {
    items.forEach(item -> log.info("data -> {}", item));
  }

}
