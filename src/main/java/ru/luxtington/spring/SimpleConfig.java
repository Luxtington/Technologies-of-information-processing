package ru.luxtington.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import ru.luxtington.spring.beans.Feedback;
import ru.luxtington.spring.beans.RandBean;
import ru.luxtington.spring.utils.SpringStudent;

import java.util.*;
import java.util.function.Predicate;

@Configuration
public class SimpleConfig {

    @Bean
    @Lazy
    public String halloBean(@Autowired BeanFactory beanFactory){
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
    public int minInt(){
        return 1;
    }

    @Bean
    public int maxInt(){
        return 5;
    }

    @Bean
    public double justDouble(){
        return 67.89;
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
