package com.gabriel.batch.delimited.file.reader;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class DelimitedFileReaderApplication {

  public static void main(final String[] args) {
    SpringApplication.run(DelimitedFileReaderApplication.class, args);
  }

}
