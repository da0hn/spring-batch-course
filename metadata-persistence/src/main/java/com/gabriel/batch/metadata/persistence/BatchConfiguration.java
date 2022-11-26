package com.gabriel.batch.metadata.persistence;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

  private final JobBuilderFactory jobBuilderFactory;
  private final StepBuilderFactory stepBuilderFactory;

  @Autowired
  public BatchConfiguration(
    final JobBuilderFactory jobBuilderFactory,
    final StepBuilderFactory stepBuilderFactory
  ) {
    this.jobBuilderFactory = jobBuilderFactory;
    this.stepBuilderFactory = stepBuilderFactory;
  }

  @Bean
  public Job printHelloJob() {
    return this.jobBuilderFactory
      .get("printHelloJob")
      .start(this.printHelloStep())
      .build();
  }

  @Bean
  public Step printHelloStep() {
    return this.stepBuilderFactory
      .get("printHelloStep")
      .tasklet((contribution, chunkContext) -> {
        System.out.println("Hello World, Step");
        return RepeatStatus.FINISHED;
      })
      .build();
  }


}
