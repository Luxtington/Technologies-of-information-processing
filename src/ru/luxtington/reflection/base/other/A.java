package ru.luxtington.reflection.base.other;

import ru.luxtington.annotations.Default;
import ru.luxtington.annotations.DefaultValuesHolder;
import ru.luxtington.annotations.ToString;
import ru.luxtington.annotations.ToStringOption;

@ToString(ToStringOption.NO)
public class A extends Entity{
    @ToString(ToStringOption.YES)
    private int aNumber;
    @Default(DefaultValuesHolder.class)
    private String aCategory;

    public A() {
    }

    public A(int aNumber, String aCategory) {
        super();
        this.aNumber = aNumber;
        this.aCategory = aCategory;
    }

    public int getaNumber(){
        return aNumber;
    }
}
