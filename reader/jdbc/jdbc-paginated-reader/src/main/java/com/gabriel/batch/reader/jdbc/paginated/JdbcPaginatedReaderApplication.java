package com.gabriel.batch.reader.jdbc.paginated;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class JdbcPaginatedReaderApplication {

  public static void main(final String[] args) {
    SpringApplication.run(JdbcPaginatedReaderApplication.class, args);
  }

}
