package ru.luxtington.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class RandBean {
    int min;
    int max;
    private static List<Integer> values = new ArrayList<>();
    private static final Random RANDOM = new Random();

    @Autowired
    public RandBean(@Qualifier("minInt") int min, @Qualifier("maxInt") int max) {
        this.min = min;
        this.max = max;
    }

    public RandBean() {

    }

    @Bean
    @Scope("prototype")
    public Integer value(){
        Integer res = RANDOM.nextInt(max + 1 - min) + min;
        if (values.contains(res) && values.size() < (max-min+1)){  // infinity
            return value();
        } else if (values.size() == (max-min+1)){
            return res;
        }
        values.add(res);
        return res;
    }

    @Override
    public String toString() {
        return "RandBean: " + value() + "!!!!!!!!!!";
    }
}
