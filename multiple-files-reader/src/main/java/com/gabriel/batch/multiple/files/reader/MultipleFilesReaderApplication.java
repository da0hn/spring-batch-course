package com.gabriel.batch.multiple.files.reader;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class MultipleFilesReaderApplication {

  public static void main(final String[] args) {
    SpringApplication.run(MultipleFilesReaderApplication.class, args);
  }

}
