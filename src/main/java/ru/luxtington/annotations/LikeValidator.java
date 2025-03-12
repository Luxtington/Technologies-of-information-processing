package ru.luxtington.annotations;

import ru.luxtington.reflection.base.other.TestBoyClass1;
import ru.luxtington.reflection.base.other.TestBoyClass2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Validate({TestBoyClass1.class, TestBoyClass2.class})
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface LikeValidator {
}