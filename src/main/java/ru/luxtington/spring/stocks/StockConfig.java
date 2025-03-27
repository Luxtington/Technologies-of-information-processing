package ru.luxtington.spring.stocks;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StockConfig {
    @Bean
    public Observer beanPrinter(){
        return new Printer();
    }

    @Bean
    public Observer beanBot(){
        return new Bot();
    }
}
