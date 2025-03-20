package ru.luxtington.main;

import ru.luxtington.main.tmp.My;
import ru.luxtington.main.tmp.Testable;
import ru.luxtington.reflection.base.other.UpCacher;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

//        Map<String, Object> res = ClassWithUtils.collect(List.of(Reflector.class, Boy.class));
//        System.out.println(res);
//        System.out.println(res.size());
//
//        B b = new B(-1, "a", -2);
//        My my = new My("hola", 1);
//        System.out.println(b);
//        System.out.println(my);
//        ClassWithUtils.reset(b, my);
//        System.out.println(b);
//        System.out.println(my);
//
//        B b = new B(-1, "a", 2);
//        System.out.println(b);
//
//        Reflector.validate(new Boy(-10, "Vasya", 22));

        List<Testable> ables = UpCacher.cache(new My("ajah", 14));
        Testable m1 = ables.get(0);
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

