package com.gabriel.batch.reader.jdbc.cursor.job.step.readers;

import com.gabriel.batch.reader.jdbc.cursor.model.Client;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.sql.DataSource;

@Configuration
public class JdbcCursorReaderConfiguration {

  @Bean
  public JdbcCursorItemReader<Client> jdbcCursorItemReader(
    @Qualifier("applicationDataSource") final DataSource dataSource
  ) {
    return new JdbcCursorItemReaderBuilder<Client>()
      .name("jdbcCursorReader")
      .dataSource(dataSource)
      .sql("SELECT * FROM client")
      .rowMapper(new BeanPropertyRowMapper<>(Client.class))
      .build();
  }

}
