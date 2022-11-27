package com.gabriel.batch.metadata.persistence.jobs;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class EvenOrOddBatchConfiguration {

  private final JobBuilderFactory jobBuilderFactory;

  public EvenOrOddBatchConfiguration(
    final JobBuilderFactory jobBuilderFactory
  ) {
    this.jobBuilderFactory = jobBuilderFactory;
  }

  @Bean
  public Job evenOrOddPrinterJob(final Step evenOrOddPrinterStep) {
    return this.jobBuilderFactory
      .get("evenOrOddPrinterJob")
      .start(evenOrOddPrinterStep)
      .incrementer(new RunIdIncrementer())
      .build();
  }


}
