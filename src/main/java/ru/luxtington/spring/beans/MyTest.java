package ru.luxtington.spring.beans;

import org.springframework.stereotype.Component;
import ru.luxtington.annotations.Cache;
import ru.luxtington.annotations.DefaultNew;
import ru.luxtington.annotations.Mutator;
import ru.luxtington.main.tmp.Testable;

@Component
@DefaultNew("valuesHolder")
public class MyTest implements Testable {
    private int originalMethodsCalls;

    @DefaultNew("halloBean")
    private String data;

    private Integer num;

    @DefaultNew("justDouble")
    private double aDouble;

    public MyTest(String data, Integer num) {
        this.data = data;
        this.num = num;
    }

    public MyTest() {
    }

    @Cache
    @Override
    public String getData() {
        System.out.println("Original data");
        originalMethodsCalls++;
        return data;
    }

    @Cache
    @Override
    public Integer getNum() {
        System.out.println("Original num");
        originalMethodsCalls++;
        return num;
    }

    @Cache
    @Override
    public String concatenate(String s, Integer n) {
        System.out.println("Original concatenation");
        originalMethodsCalls++;
        return s + " " + n + "!";
    }

    @Cache
    @Override
    public String concatenate(String n1, String n2, String n3) {
        System.out.println("Original concatenation");
        originalMethodsCalls++;
        return String.format("%s! + %s! + %s!", n1, n2, n3);
    }

    @Override
    public int summOneAndTwo() {
        return 1 + 2;
    }

    @Mutator
    @Override
    public void setData(String data) {
        this.data = data;
    }

    public int getOriginalMethodsCalls() {
        return originalMethodsCalls;
    }

    @Override
    public String toString() {
        return "MyTest{" +
                "originalMethodsCalls=" + originalMethodsCalls +
                ", data='" + data + '\'' +
                ", num=" + num +
                ", aDouble=" + aDouble +
                '}';
    }
}