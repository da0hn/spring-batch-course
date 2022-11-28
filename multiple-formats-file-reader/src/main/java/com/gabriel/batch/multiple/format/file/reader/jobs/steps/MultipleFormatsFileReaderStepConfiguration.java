package com.gabriel.batch.multiple.format.file.reader.jobs.steps;

import com.gabriel.batch.multiple.format.file.reader.RawFileData;
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
    final FlatFileItemReader<? extends RawFileData> multipleFormatsFileClientReader,
    final SimpleLoggerWriter simpleLoggerWriter
  ) {
    return this.stepBuilderFactory
      .get("multipleFormatsFileReaderStep")
      .<RawFileData, RawFileData>chunk(1)
      .reader(multipleFormatsFileClientReader)
      .writer(simpleLoggerWriter)
      .build();
  }


}
