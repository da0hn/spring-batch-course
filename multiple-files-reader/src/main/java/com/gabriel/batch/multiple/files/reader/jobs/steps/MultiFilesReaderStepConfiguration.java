package com.gabriel.batch.multiple.files.reader.jobs.steps;

import com.gabriel.batch.multiple.files.reader.jobs.steps.writers.SimpleLoggerWriter;
import com.gabriel.batch.multiple.files.reader.model.Client;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@AllArgsConstructor
public class MultiFilesReaderStepConfiguration {

  private final StepBuilderFactory stepBuilderFactory;

  @Bean
  public Step multiFilesReaderStep(
    final MultiResourceItemReader<? extends Client> multiResourceItemReader,
    final SimpleLoggerWriter simpleLoggerWriter
  ) {
    return this.stepBuilderFactory
      .get("multiFilesReaderStep")
      .<Client, Client>chunk(1)
      .reader(multiResourceItemReader)
      .writer(simpleLoggerWriter)
      .build();
  }


}
