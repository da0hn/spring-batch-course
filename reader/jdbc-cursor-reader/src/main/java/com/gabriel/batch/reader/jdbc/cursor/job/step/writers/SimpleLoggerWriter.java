package com.gabriel.batch.reader.jdbc.cursor.job.step.writers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class SimpleLoggerWriter implements ItemWriter<Object> {


  @Override
  public void write(final List<? extends Object> items) throws Exception {
    items.forEach(item -> log.info("data -> {}", item));
  }

}
