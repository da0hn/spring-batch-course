package com.gabriel.batch.delimited.files.reader.jobs.steps.readers;

import com.gabriel.batch.delimited.files.reader.Client;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class DelimitedFileClientReaderConfiguration {


  @Bean
  @StepScope
  public FlatFileItemReader<Client> delimitedFileClientReader(
    @Value("#{jobParameters['data']}") final Resource dataResource
  ) {
    return new FlatFileItemReaderBuilder<Client>()
      .name("delimitedFileClientReader")
      .resource(dataResource)
      .delimited()
      .names("name", "surname", "age", "email")
      .targetType(Client.class)
      .build();
  }

}
