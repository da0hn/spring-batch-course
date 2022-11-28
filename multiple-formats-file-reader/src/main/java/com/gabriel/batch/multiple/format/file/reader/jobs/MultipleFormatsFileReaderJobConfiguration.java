package com.gabriel.batch.multiple.format.file.reader.jobs;

import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@AllArgsConstructor
public class MultipleFormatsFileReaderJobConfiguration {

  private final JobBuilderFactory jobBuilderFactory;

  @Bean
  public Job multipleFormatsFileReaderJob(final Step multipleFormatsFileReaderStep) {
    return this.jobBuilderFactory
      .get("multipleFormatsFileReaderJob")
      .start(multipleFormatsFileReaderStep)
      .incrementer(new RunIdIncrementer())
      .build();
  }

}
