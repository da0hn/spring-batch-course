package com.gabriel.batch.reader.jdbc.cursor.job.step.readers;

import com.gabriel.batch.reader.jdbc.cursor.model.Client;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;


@Configuration
public class SkipExceptionJdbcReaderConfiguration {

  @Bean
  public ItemReader<Client> skipExceptionReader(@Qualifier("applicationDataSource") final DataSource dataSource) {
    return new JdbcCursorItemReaderBuilder<Client>()
      .name("skipExceptionReader")
      .dataSource(dataSource)
      .sql("SELECT * FROM client")
      .rowMapper(this.rowMapper())
      .build();
  }

  private RowMapper<Client> rowMapper() {
    return (rs, rowNum) -> {
      // raise exception treating runtime error
      if (rs.getRow() == 5) {
        throw new SQLException(String.format("Encerrando a execução - Cliente %s inválido", rs.getString("email")));
      }
      return this.clientRowMapper(rs);
    };
  }

  private Client clientRowMapper(final ResultSet rs) throws SQLException {
    return Client.builder()
      .name(rs.getString("name"))
      .surname(rs.getString("surname"))
      .age(rs.getString("age"))
      .email(rs.getString("email"))
      .build();
  }

}
