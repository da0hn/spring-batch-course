package com.gabriel.batch.reader.jdbc.paginated.job;

import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@AllArgsConstructor
public class JobConfiguration {

  private final JobBuilderFactory jobBuilderFactory;

  @Bean
  public Job job(final Step jdbcCursorReaderStep) {
    return this.jobBuilderFactory
      .get("job")
      .start(jdbcCursorReaderStep)
      .incrementer(new RunIdIncrementer())
      .build();
  }


}
