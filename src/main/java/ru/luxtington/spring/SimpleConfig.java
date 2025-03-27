package ru.luxtington.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import ru.luxtington.oop.people.studying.Student;
import ru.luxtington.spring.beans.Feedback;
import ru.luxtington.spring.beans.RandBean;
import ru.luxtington.spring.utils.SpringStudent;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Configuration
public class SimpleConfig {
    @Bean
    public String halloBean(){
        return "hallo, world!";
    }
//    @Bean
//    public int randBean(int min, int max){
//        Random r = new Random();
//        return r.nextInt(100);
//    }

    @Bean
    @Lazy
    public Date dateBean(){
        return new Date();
    }

    @Bean
    public Predicate<Integer> checkerBean(){
        return num -> (num >=2 && num <= 5);
    }

    @Bean
    public int min(){
        return 1;
    }

    @Bean
    public int max(){
        return 5;
    }

    @Bean
    public Feedback feedback1(){
        return new Feedback("Very good", 4);
    }

    @Bean
    public Feedback feedback2(){
        return new Feedback("So so", 3);
    }

    @Bean
    public Feedback feedback3(RandBean randBean){
        return new Feedback("I don't know", randBean.value());
    }

    @Bean
    @Scope("prototype")
    public Feedback bestFeedback(List<Feedback> feedbacks){
        return feedbacks.stream()
                .max(Comparator.comparingInt(Feedback::getMark)).
                orElse(new Feedback("Impossible", 999));
    }

    @Bean
    public SpringStudent<Integer> studentGood(Predicate<Integer> checker){
        return new SpringStudent<>("Good Bob", checker, List.of(4,5,5,5));
    }
    @Bean
    public SpringStudent<Integer> studentBad(Predicate<Integer> checker){
        return new SpringStudent<>("Bad Dima", checker, List.of(3,2,2,2));
    }
}
