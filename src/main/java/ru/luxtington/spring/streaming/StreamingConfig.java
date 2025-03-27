package ru.luxtington.spring.streaming;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

@Configuration
public class StreamingConfig {
    @Bean
    public String beanSourceFile(){
        return "C:\\СГТУ\\ИФСТ22\\Technologies-of-information-processing\\src\\main\\java\\ru\\luxtington\\spring\\streaming\\test.txt";
    }

    @Bean
    public String beanOutputFile(){
        return "C:\\СГТУ\\ИФСТ22\\Technologies-of-information-processing\\src\\main\\java\\ru\\luxtington\\spring\\streaming\\res.txt";
    }

    @Bean
    public Writeable beanWriterTXT(){
        return new WriterToTXT();
    }

    @Bean
    public Readable beanReaderTXT(){
        return new ReaderFromTXT();
    }

    @Bean
    @Order(1)
    public Puttable beanUpperAction(){
        return data -> data.stream().map(String::toUpperCase).toList();
    }

    @Bean
    @Order(2)
    public Puttable beanRemoveLetterAction(){
        return data -> data.stream().map(s -> s.replaceAll("A", "")).toList();
    }

    @Bean
    @Order(3)
    public Puttable beanSaveLongWords(){
        return data -> data.stream().filter(s -> s.length() > 4).toList();
    }
}
