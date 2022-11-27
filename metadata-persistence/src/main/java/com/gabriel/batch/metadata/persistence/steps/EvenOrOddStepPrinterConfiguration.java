package com.gabriel.batch.metadata.persistence.steps;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Configuration
public class EvenOrOddStepPrinterConfiguration {

  private final StepBuilderFactory stepBuilderFactory;

  public EvenOrOddStepPrinterConfiguration(final StepBuilderFactory stepBuilderFactory) {
    this.stepBuilderFactory = stepBuilderFactory;
  }

  @Bean
  public Step evenOrOddPrinterStep() {
    return this.stepBuilderFactory
      .get("evenOrOddPrinterStep")
      .<Integer, String>chunk(10)
      .reader(this.countUntilTen())
      .processor(this.oddOrEvenProcessor())
      .writer(this.printWriter())
      .build();

  }

  private IteratorItemReader<Integer> countUntilTen() {
    final var data = IntStream.rangeClosed(1, 10)
      .boxed()
      .collect(Collectors.toList());
    return new IteratorItemReader<>(data);
  }

  private FunctionItemProcessor<? super Integer, String> oddOrEvenProcessor() {
    return new FunctionItemProcessor<>(
      (item) -> item % 2 == 0 ? String.format("%d is even", item) : String.format("%d is odd", item)
    );
  }

  private ItemWriter<? super String> printWriter() {
    return items -> items.forEach(System.out::println);
  }

}
