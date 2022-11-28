package com.gabriel.batch.flatfile.reader.jobs.steps;

import com.gabriel.batch.flatfile.reader.Client;
import com.gabriel.batch.flatfile.reader.jobs.steps.writers.SimpleLoggerWriter;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@AllArgsConstructor
public class FlatFileReaderStepConfiguration {

  private final StepBuilderFactory stepBuilderFactory;

  @Bean
  public Step flatFileReaderStep(
    final FlatFileItemReader<Client> flatFileClientReader,
    final SimpleLoggerWriter simpleLoggerWriter
  ) {
    return this.stepBuilderFactory
      .get("flatFileReaderStep")
      .<Client, Client>chunk(1)
      .reader(flatFileClientReader)
      .writer(simpleLoggerWriter)
      .build();
  }


}
