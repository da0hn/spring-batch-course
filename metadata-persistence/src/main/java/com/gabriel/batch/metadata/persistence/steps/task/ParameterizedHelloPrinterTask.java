package com.gabriel.batch.metadata.persistence.steps.task;

import lombok.extern.log4j.Log4j2;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@StepScope
@Log4j2
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
    log.info("Hello, {}", this.name);
    return RepeatStatus.FINISHED;
  }

}
