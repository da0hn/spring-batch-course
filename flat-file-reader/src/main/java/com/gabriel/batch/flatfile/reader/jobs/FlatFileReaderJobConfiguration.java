package com.gabriel.batch.flatfile.reader.jobs;

import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@AllArgsConstructor
public class FlatFileReaderJobConfiguration {

  private final JobBuilderFactory jobBuilderFactory;

  @Bean
  public Job flatFileReaderJob(final Step flatFileReaderStep) {
    return this.jobBuilderFactory
      .get("flatFileReaderJob")
      .start(flatFileReaderStep)
      .incrementer(new RunIdIncrementer())
      .build();
  }

}
