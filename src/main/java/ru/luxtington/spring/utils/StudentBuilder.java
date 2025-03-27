package ru.luxtington.spring.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Component
public class StudentBuilder {
    private final Predicate<Integer> checker;

    @Autowired
    public StudentBuilder(Predicate<Integer> checker) {
        this.checker = checker;
    }

    public SpringStudent<?> createStudent(String name){
        return new SpringStudent<>(name, checker, new ArrayList<>());
    }

    public <T> SpringStudent<T> createStudent(String name, List<T> marks){
        return new SpringStudent<T>(name, (Predicate<T>) checker, marks);
    }
}
