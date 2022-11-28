package com.gabriel.batch.reader.jdbc.paginated.job.step;

import com.gabriel.batch.reader.jdbc.paginated.job.step.writers.SimpleLoggerWriter;
import com.gabriel.batch.reader.jdbc.paginated.model.Client;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@AllArgsConstructor
public class StepConfiguration {

  private final StepBuilderFactory stepBuilderFactory;


  @Bean
  public Step jdbcCursorReaderStep(
    final ItemReader<? extends Client> itemReader,
    final SimpleLoggerWriter simpleLoggerWriter
  ) {
    return this.stepBuilderFactory
      .get("genericStep")
      .<Client, Client>chunk(1)
      .reader(itemReader)
      .writer(simpleLoggerWriter)
      .build();
  }

}
