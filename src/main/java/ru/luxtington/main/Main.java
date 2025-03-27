package ru.luxtington.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.luxtington.spring.beans.Feedback;
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

//        ApplicationContext ctx = new AnnotationConfigApplicationContext(
//                "ru.luxtington.spring"
//        );
//        System.out.println(ctx.getBean("dateBean"));
//        System.out.println(ctx.getBean("halloBean"));
//        Thread.sleep(2000);
//        System.out.println(ctx.getBean("dateBean"));
//
//        Predicate<Integer> p = (Predicate<Integer>) ctx.getBean("checkerBean");
//        System.out.println(p.test(6));
//        System.out.println(ctx.getBean("min") + ", " + ctx.getBean("max"));

//        for (int i = 0; i < 10; i++){
//            System.out.println(ctx.getBean("randBean"));
//        }

//        System.out.println(ctx.getBean("feedback1"));
//        System.out.println(ctx.getBean("feedback2"));
//        System.out.println(ctx.getBean("feedback3"));
//        System.out.println("BEST = " + ctx.getBean("bestFeedback"));

//        System.out.println(ctx.getBean("studentGood"));
//        System.out.println(ctx.getBean("studentBad"));

//        StudentBuilder sb = (StudentBuilder) ctx.getBean("studentBuilder");
//        System.out.println(sb.createStudent("Vasya"));
//        System.out.println(sb.createStudent("Gena", List.of(4,5,3)));

//        ApplicationContext ctxFile = new AnnotationConfigApplicationContext(
//                "ru.luxtington.spring"
//        );
//
//        FileActor fa = (FileActor) ctxFile.getBean("fileActor");
//        fa.doActionsWithFile();


//        ApplicationContext ctxTraffic = new AnnotationConfigApplicationContext(
//                "ru.luxtington.spring"
//        );
//
//        TrafficLight tl = (TrafficLight) ctxTraffic.getBean("trafficLight");
//        for (int i = 0; i < 10; i++)
//            tl.next();

//        ApplicationContext ctxStocks = new AnnotationConfigApplicationContext(
//                "ru.luxtington.spring"
//        );
//        Printer p = (Printer) ctxStocks.getBean("beanPrinter");
//        Bot b = (Bot) ctxStocks.getBean("beanBot");
//
//        Stock s1 = new Stock(50, "TSL"), s2 = new Stock(103, "TB"), s3 = new Stock(192, "JSJD");
//
//        s1.addObserver(p);
//        s2.addObserver(b);
//
//        s1.setCost(999);
//        s2.setCost(10);

    }
}

