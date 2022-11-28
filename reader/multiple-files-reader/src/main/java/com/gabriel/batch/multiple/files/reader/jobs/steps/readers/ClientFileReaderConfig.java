package com.gabriel.batch.multiple.files.reader.jobs.steps.readers;

import com.gabriel.batch.multiple.files.reader.model.ReadableFileData;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ClientFileReaderConfig {


  @Bean
  @StepScope
  public FlatFileItemReader<ReadableFileData> clientFileReader(
    @Value("#{jobParameters['data']}") final Resource dataResource,
    final LineMapper<ReadableFileData> lineMapper
  ) {
    return new FlatFileItemReaderBuilder<ReadableFileData>()
      .name("clientFileReader")
      .resource(dataResource)
      .lineMapper(lineMapper)
      .build();

  }

}
