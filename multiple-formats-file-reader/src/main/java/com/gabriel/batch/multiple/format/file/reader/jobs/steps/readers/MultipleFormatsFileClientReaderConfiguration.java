package com.gabriel.batch.multiple.format.file.reader.jobs.steps.readers;

import com.gabriel.batch.multiple.format.file.reader.Client;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class MultipleFormatsFileClientReaderConfiguration {


  @Bean
  @StepScope
  public FlatFileItemReader<Client> multipleFormatsFileClientReader(
    @Value("#{jobParameters['data']}") final Resource dataResource
  ) {
    return null;
  }

}
