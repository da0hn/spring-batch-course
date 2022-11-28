package com.gabriel.batch.reader.jdbc.cursor;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class JdbcCursorReaderApplication {

  public static void main(final String[] args) {
    SpringApplication.run(JdbcCursorReaderApplication.class, args);
  }

}
