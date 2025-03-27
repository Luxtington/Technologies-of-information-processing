package ru.luxtington.spring.traffic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;

@Configuration
public class TrafficConfig {
    @Bean
    public Color redColor(@Lazy @Qualifier("yellowAfterRedColor") Color yellowAfterRedColor){
        return new Color() {
            @Override
            public Color switchToNext() {
                return yellowAfterRedColor;
            }

            @Override
            public void shine() {
                System.out.println("Red");
            }
        };
    }

    @Bean
    public Color yellowAfterRedColor(@Qualifier("greenColor") Color greenColor){
        return new Color() {
            @Override
            public Color switchToNext() {
                return greenColor;
            }

            @Override
            public void shine() {
                System.out.println("Yellow");
            }
        };
    }

    @Bean
    public Color greenColor(@Qualifier("yellowAfterGreenColor") Color yellowAfterGreenColor){
        return new Color() {
            @Override
            public Color switchToNext() {
                return yellowAfterGreenColor;
            }

            @Override
            public void shine() {
                System.out.println("Green");
            }
        };
    }

    @Bean
    public Color yellowAfterGreenColor(@Qualifier("redColor") Color redColor){
        return new Color() {
            @Override
            public Color switchToNext() {
                return redColor;
            }

            @Override
            public void shine() {
                System.out.println("Yellow");
            }
        };
    }
}
