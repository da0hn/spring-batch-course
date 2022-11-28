package com.gabriel.batch.multiple.files.reader.jobs.steps.readers;

import com.gabriel.batch.multiple.files.reader.model.Client;
import com.gabriel.batch.multiple.files.reader.model.ReadableFileData;
import com.gabriel.batch.multiple.files.reader.model.Transaction;
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
  public PatternMatchingCompositeLineMapper<ReadableFileData> lineMapper() {
    final var lineMapper = new PatternMatchingCompositeLineMapper<ReadableFileData>();
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

  private Map<String, FieldSetMapper<ReadableFileData>> fieldSetMappers() {
    final var fieldSetMappers = new HashMap<String, FieldSetMapper<ReadableFileData>>();
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

  private FieldSetMapper<ReadableFileData> fieldSetMapper(final Class<? extends ReadableFileData> clazz) {
    final var beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<ReadableFileData>();
    beanWrapperFieldSetMapper.setTargetType(clazz);
    return beanWrapperFieldSetMapper;
  }

}
