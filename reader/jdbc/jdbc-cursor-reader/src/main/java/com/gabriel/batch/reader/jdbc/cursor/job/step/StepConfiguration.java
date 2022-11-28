package com.gabriel.batch.reader.jdbc.cursor.job.step;

import com.gabriel.batch.reader.jdbc.cursor.job.step.writers.SimpleLoggerWriter;
import com.gabriel.batch.reader.jdbc.cursor.model.Client;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@AllArgsConstructor
public class StepConfiguration {

  private final StepBuilderFactory stepBuilderFactory;


  @Bean
  public Step jdbcCursorReaderStep(
    @Qualifier("skipExceptionReader") final ItemReader<? extends Client> itemReader,
    final SimpleLoggerWriter simpleLoggerWriter
  ) {
    return this.stepBuilderFactory
      .get("genericStep")
      .<Client, Client>chunk(1)
      .reader(itemReader)
      .writer(simpleLoggerWriter)
      // use qualifier `skipExceptionReader` to simulate exception
      .faultTolerant() // make step error tolerant (continue processing when runtime exception is throw)
      .skip(Exception.class) // skip only exception type marked
      .skipLimit(2) // only tolerates two errors on processing
      .build();
  }

}
