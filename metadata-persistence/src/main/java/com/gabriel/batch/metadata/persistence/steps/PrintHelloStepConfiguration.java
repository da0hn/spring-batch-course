package com.gabriel.batch.metadata.persistence.steps;

import com.gabriel.batch.metadata.persistence.steps.task.ParameterizedHelloPrinterTask;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrintHelloStepConfiguration {

  private final StepBuilderFactory stepBuilderFactory;

  public PrintHelloStepConfiguration(final StepBuilderFactory stepBuilderFactory) {
    this.stepBuilderFactory = stepBuilderFactory;
  }

  @Bean
  public Step printHelloStep(final ParameterizedHelloPrinterTask helloPrinterTask) {
    return this.stepBuilderFactory
      .get("printHelloStep")
      .tasklet(helloPrinterTask)
      .build();
  }

}
