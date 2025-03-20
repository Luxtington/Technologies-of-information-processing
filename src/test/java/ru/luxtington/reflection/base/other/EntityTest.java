package ru.luxtington.reflection.base.other;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.luxtington.oop.different.animals.cats.Cat;

public class EntityTest {
    private final static String TO_STRING_ERROR = "String imaginations are different";

    @Test
    public void testBToString() {
        B b = new B(-1, "a", 2);
        String expected = "B { bNum=2.0,aNumber=-1 }";
        String actual = b.toString();
        Assertions.assertEquals(expected, actual, TO_STRING_ERROR);
    }

    @Test
    public void testCatToString() {
        Cat cat = new Cat("Barsik", 10);
        String expected = "Cat { name=Barsik,age==10 }";
        String actual = cat.toString();
        Assertions.assertEquals(expected, actual, TO_STRING_ERROR);
    }
}