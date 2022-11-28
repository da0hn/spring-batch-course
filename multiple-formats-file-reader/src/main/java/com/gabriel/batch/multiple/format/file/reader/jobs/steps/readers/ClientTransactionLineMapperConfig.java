package com.gabriel.batch.multiple.format.file.reader.jobs.steps.readers;

import com.gabriel.batch.multiple.format.file.reader.Client;
import com.gabriel.batch.multiple.format.file.reader.Transaction;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.mapping.PatternMatchingCompositeLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ClientTransactionLineMapperConfig {

  @Bean
  public PatternMatchingCompositeLineMapper lineMapper() {
    final var lineMapper = new PatternMatchingCompositeLineMapper();
    lineMapper.setTokenizers(this.tokenizers());
    lineMapper.setFieldSetMappers(this.fieldSetMappers());
    return lineMapper;
  }

  private Map<String, LineTokenizer> tokenizers() {
    final Map<String, LineTokenizer> tokenizers = new HashMap<>();
    tokenizers.put("0*", this.clientLineTokenizer());
    tokenizers.put("1*", this.transactionLineTokenizers());
    return tokenizers;
  }

  private Map<String, Object> fieldSetMappers() {
    final var fieldSetMappers = new HashMap<String, Object>();
    fieldSetMappers.put("0*", this.fieldSetMapper(Client.class));
    fieldSetMappers.put("1*", this.fieldSetMapper(Transaction.class));
    return fieldSetMappers;
  }

  private LineTokenizer clientLineTokenizer() {
    final DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer(",");
    delimitedLineTokenizer.setNames("name", "surname", "age", "email");
    delimitedLineTokenizer.setIncludedFields(1, 2, 3, 4);
    return delimitedLineTokenizer;
  }

  private LineTokenizer transactionLineTokenizers() {
    final var delimitedLineTokenizer = new DelimitedLineTokenizer(",");
    delimitedLineTokenizer.setNames("id", "name", "value");
    delimitedLineTokenizer.setIncludedFields(1, 2, 3);
    return delimitedLineTokenizer;
  }

  private <T> FieldSetMapper<T> fieldSetMapper(final Class<T> clazz) {
    final var beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<T>();
    beanWrapperFieldSetMapper.setTargetType(clazz);
    return beanWrapperFieldSetMapper;
  }

}
