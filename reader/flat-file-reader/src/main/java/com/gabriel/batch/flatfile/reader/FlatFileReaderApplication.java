package com.gabriel.batch.flatfile.reader;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class FlatFileReaderApplication {

  public static void main(final String[] args) {
    SpringApplication.run(FlatFileReaderApplication.class, args);
  }

}
