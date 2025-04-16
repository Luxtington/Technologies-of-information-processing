package ru.luxtington.spring.beans;

import org.springframework.stereotype.Component;

@Component
public class CatBean {
    public String nickname;
    public int age;

    public CatBean() {
    }

    @Override
    public String toString() {
        return "CatBean{" +
                "nickname='" + nickname + '\'' +
                ", age=" + age +
                '}';
    }
}
