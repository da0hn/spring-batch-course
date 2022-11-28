package com.gabriel.batch.multiple.files.reader.jobs;

import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@AllArgsConstructor
public class MultiFilesReaderJobConfiguration {

  private final JobBuilderFactory jobBuilderFactory;

  @Bean
  public Job multiFilesReaderJob(final Step multiFilesReaderStep) {
    return this.jobBuilderFactory
      .get("multiFilesReaderJob")
      .start(multiFilesReaderStep)
      .incrementer(new RunIdIncrementer())
      .build();
  }

}
