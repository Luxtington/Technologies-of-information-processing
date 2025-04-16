package ru.luxtington.spring.beans;

import org.springframework.stereotype.Component;

@Component
public class BoyBean {
    private String name;
    private int age;

    public BoyBean() {
    }

    @Override
    public String toString() {
        return "BoyBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
