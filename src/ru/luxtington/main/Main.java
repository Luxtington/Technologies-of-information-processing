package ru.luxtington.main;

import ru.luxtington.annotations.*;
import ru.luxtington.oop.people.family.Boy;
import ru.luxtington.reflection.base.other.B;
import ru.luxtington.reflection.base.other.Cacher;
import ru.luxtington.reflection.base.other.Reflector;
import ru.luxtington.reflection.hard.ClassWithUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {

//        Map<String, Object> res = ClassWithUtils.collect(List.of(Reflector.class, Boy.class));
//        System.out.println(res);
//        System.out.println(res.size());

//        B b = new B(-1, "a", -2);
//        My my = new My("hola");
//        System.out.println(b);
//        System.out.println(my);
//        ClassWithUtils.reset(b, my);
//        System.out.println(b);
//        System.out.println(my);

//        B b = new B(-1, "a", 2);
//        System.out.println(b);

//        Reflector.validate(new Boy(-10, "Vasya", 22));

        List<Able> ables = Cacher.cache(new My("ajah", 14));
        Able m1 = ables.get(0);
        System.out.println(m1.getNum());
        System.out.println(m1.getData());
        System.out.println(m1.getData());
        System.out.println("============");
        m1.setData("ratata");
        System.out.println(m1.getData());
        System.out.println(m1.getData());
        System.out.println(m1.getNum());


    }
}

interface Able {
    String getData();
    Integer getNum();
    void setData(String data);
}
@Cache("getData")
@Default(DefaultValuesHolder.class)
class My implements Able {
    private String data;
    public Integer num;

    public My(String data, Integer num) {
        this.data = data;
        this.num = num;
    }

    @Override
    public String getData() {
        System.out.println("Original data");
        return data;
    }

    public Integer getNum() {
        System.out.println("Original num");
        return num;
    }

    @Override
    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "My{" +
                "data='" + data + '\'' +
                '}';
    }
}