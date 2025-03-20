package ru.luxtington.main.tmp;

import ru.luxtington.annotations.Cache;
import ru.luxtington.annotations.Default;
import ru.luxtington.annotations.DefaultValuesHolder;
import ru.luxtington.annotations.Mutator;

@Default(DefaultValuesHolder.class)
public class My implements Testable {
    private int originalMethodsCalls;
    private String data;
    public Integer num;

    public My(String data, Integer num) {
        this.data = data;
        this.num = num;
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
}
