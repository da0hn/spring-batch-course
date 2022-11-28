package com.gabriel.batch.multiple.files.reader.jobs.steps.readers;

import com.gabriel.batch.multiple.files.reader.model.Client;
import com.gabriel.batch.multiple.files.reader.model.ReadableFileData;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.builder.MultiResourceItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class MultiFilesClientReaderConfig {

  @Bean
  @StepScope
  public MultiResourceItemReader<Client> multiFilesClientReader(
    @Value("#{jobParameters['files']}") final Resource[] files,
    final FlatFileItemReader<? extends ReadableFileData> clientFileReader
  ) {
    return new MultiResourceItemReaderBuilder<Client>()
      .name("multiFilesClientReader")
      .resources(files)
      .delegate(new ClientTransactionReader(clientFileReader))
      .build();
  }

}
