package com.gabriel.batch.delimited.files.reader.jobs;

import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@AllArgsConstructor
public class DelimitedFileReaderJobConfiguration {

  private final JobBuilderFactory jobBuilderFactory;

  @Bean
  public Job flatFileReaderJob(final Step delimitedFileReaderStep) {
    return this.jobBuilderFactory
      .get("delimitedFileReaderJob")
      .start(delimitedFileReaderStep)
      .incrementer(new RunIdIncrementer())
      .build();
  }

}
