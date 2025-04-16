package ru.luxtington.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.luxtington.reflection.base.other.B;
import ru.luxtington.reflection.hard.Remembers;
import ru.luxtington.spring.SimpleConfig;
import ru.luxtington.spring.beans.Feedback;
import ru.luxtington.spring.beans.MyTest;
import ru.luxtington.spring.stocks.Bot;
import ru.luxtington.spring.stocks.Printer;
import ru.luxtington.spring.stocks.Stock;
import ru.luxtington.spring.streaming.FileActor;
import ru.luxtington.spring.streaming.ReaderFromTXT;
import ru.luxtington.spring.streaming.WriterToTXT;
import ru.luxtington.spring.traffic.TrafficLight;
import ru.luxtington.spring.utils.StudentBuilder;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws Exception {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(
                "ru.luxtington.spring"
        );

//        System.out.println(ctx.getBean("boyBean"));
//        System.out.println(ctx.getBean("catBean"));
//        System.out.println(ctx.getBean("randBean"));
//        System.out.println(ctx.getBean("randBean"));

//     System.out.println(ctx.getBean("myTest"));

        //System.out.println(ctx.getBean("halloBean"));
        //System.out.println(ctx.getBean("girl"));

//        MyTest myTest = (MyTest) ctx.getBean("myTest");
//        myTest.setData("asd");
//        myTest.getData();
//        myTest.getData();

    }
}

