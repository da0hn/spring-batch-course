package com.gabriel.batch.delimited.file.reader.jobs.steps;

import com.gabriel.batch.delimited.file.reader.Client;
import com.gabriel.batch.delimited.file.reader.jobs.steps.writers.SimpleLoggerWriter;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@AllArgsConstructor
public class DelimitedFileReaderStepConfiguration {

  private final StepBuilderFactory stepBuilderFactory;

  @Bean
  public Step flatFileReaderStep(
    final FlatFileItemReader<Client> delimitedFileClientReader,
    final SimpleLoggerWriter simpleLoggerWriter
  ) {
    return this.stepBuilderFactory
      .get("delimitedFileReaderStep")
      .<Client, Client>chunk(1)
      .reader(delimitedFileClientReader)
      .writer(simpleLoggerWriter)
      .build();
  }


}
