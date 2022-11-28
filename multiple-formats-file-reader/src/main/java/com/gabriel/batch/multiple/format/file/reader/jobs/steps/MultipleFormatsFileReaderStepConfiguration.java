package com.gabriel.batch.multiple.format.file.reader.jobs.steps;

import com.gabriel.batch.multiple.format.file.reader.ReadableFileData;
import com.gabriel.batch.multiple.format.file.reader.jobs.steps.readers.ClientTransactionReader;
import com.gabriel.batch.multiple.format.file.reader.jobs.steps.writers.SimpleLoggerWriter;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@AllArgsConstructor
public class MultipleFormatsFileReaderStepConfiguration {

  private final StepBuilderFactory stepBuilderFactory;

  @Bean
  public Step multipleFormatsFileReaderStep(
    final FlatFileItemReader<? extends ReadableFileData> multipleFormatsFileClientReader,
    final SimpleLoggerWriter simpleLoggerWriter
  ) {
    return this.stepBuilderFactory
      .get("multipleFormatsFileReaderStep")
      .<ReadableFileData, ReadableFileData>chunk(1)
      .reader(new ClientTransactionReader(multipleFormatsFileClientReader))
      .writer(simpleLoggerWriter)
      .build();
  }


}
