package ru.luxtington.reflection.base.other;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import ru.luxtington.oop.different.animals.cats.Cat;

public class EntityTest {

    @Test
    public void test1() {
        B b = new B(-1, "a", 2);
        String expected = "B { bNum=2.0,aNumber=-1 }";
        String actual = b.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        Cat cat = new Cat("Barsik", 10);
        String expected = "Cat { name=Barsik,age==10 }";
        String actual = cat.toString();
        Assertions.assertEquals(expected, actual);
    }
}