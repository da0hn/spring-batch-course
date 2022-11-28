package com.gabriel.batch.reader.jdbc.paginated.job.step.readers;

import com.gabriel.batch.reader.jdbc.paginated.model.Client;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.sql.DataSource;

@Configuration
public class JdbcPaginatedReaderConfiguration {

  @Bean
  public JdbcPagingItemReader<Client> jdbcPagingItemReader(
    @Qualifier("applicationDataSource") final DataSource dataSource,
    final PagingQueryProvider queryProvider
  ) {
    return new JdbcPagingItemReaderBuilder<Client>()
      .name("jdbcPaginatedReader")
      .dataSource(dataSource)
      .queryProvider(queryProvider)
      .pageSize(1)
      .rowMapper(new BeanPropertyRowMapper<>(Client.class))
      .build();
  }

  @Bean
  public SqlPagingQueryProviderFactoryBean queryProvider(@Qualifier("applicationDataSource") final DataSource dataSource) {
    final var queryProvider = new SqlPagingQueryProviderFactoryBean();
    queryProvider.setDataSource(dataSource);
    queryProvider.setSelectClause("SELECT *");
    queryProvider.setFromClause("FROM client");
    queryProvider.setSortKey("email");
    return queryProvider;
  }

}
