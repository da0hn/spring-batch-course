package com.gabriel.batch.flatfile.reader.jobs.steps.readers;

import com.gabriel.batch.flatfile.reader.Client;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class FlatFileClientReaderConfiguration {


  @Bean
  @StepScope
  public FlatFileItemReader<Client> flatFileClientReader(
    @Value("#{jobParameters['data']}") final Resource dataResource
  ) {

    return new FlatFileItemReaderBuilder<Client>()
      .name("flatFileClientReader")
      .resource(dataResource)
      .fixedLength()
      .columns(new Range(1, 10), new Range(11, 20), new Range(21, 23), new Range(24, 43))
      .names("name", "surname", "age", "email")
      .targetType(Client.class)
      .build();
  }

}
