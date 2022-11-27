package com.gabriel.batch.metadata.persistence.steps.task;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@StepScope
@Component
public class ParameterizedHelloPrinterTask implements Tasklet {

  private final String name;

  public ParameterizedHelloPrinterTask(@Value("#{jobParameters['name']}") final String name) {
    this.name = name;
  }


  @Override
  public RepeatStatus execute(
    final StepContribution contribution,
    final ChunkContext chunkContext
  ) throws Exception {
    System.out.printf("Hello, %s%n", this.name);
    return RepeatStatus.FINISHED;
  }

}
