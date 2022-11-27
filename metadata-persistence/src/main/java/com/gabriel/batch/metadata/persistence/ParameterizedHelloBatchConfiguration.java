package com.gabriel.batch.metadata.persistence;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class ParameterizedHelloBatchConfiguration {

  private final JobBuilderFactory jobBuilderFactory;
  private final StepBuilderFactory stepBuilderFactory;

  @Autowired
  public ParameterizedHelloBatchConfiguration(
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
      .incrementer(new RunIdIncrementer())
      .build();
  }


  @Bean
  public Step printHelloStep() {
    return this.stepBuilderFactory
      .get("printHelloStep")
      .tasklet(this.printHelloTasklet(null))
      .build();
  }


  @Bean
  @StepScope
  public Tasklet printHelloTasklet(@Value("#{jobParameters['name']}") final String name) {
    return (contribution, chunkContext) -> {
      System.out.printf("Hello, %s%n", name);
      return RepeatStatus.FINISHED;
    };
  }


}
