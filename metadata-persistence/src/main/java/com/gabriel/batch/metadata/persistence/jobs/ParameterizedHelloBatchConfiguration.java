package com.gabriel.batch.metadata.persistence.jobs;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class ParameterizedHelloBatchConfiguration {

  private final JobBuilderFactory jobBuilderFactory;

  @Autowired
  public ParameterizedHelloBatchConfiguration(
    final JobBuilderFactory jobBuilderFactory
  ) {
    this.jobBuilderFactory = jobBuilderFactory;
  }

  @Bean
  public Job printHelloJob(final Step printHelloStep) {
    return this.jobBuilderFactory
      .get("printHelloJob")
      .start(printHelloStep)
      .incrementer(new RunIdIncrementer())
      .build();
  }

}
