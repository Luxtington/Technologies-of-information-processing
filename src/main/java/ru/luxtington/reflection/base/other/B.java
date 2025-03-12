package ru.luxtington.reflection.base.other;

import ru.luxtington.annotations.Default;
import ru.luxtington.annotations.DefaultValuesHolder;
import ru.luxtington.annotations.ToString;
import ru.luxtington.annotations.ToStringOption;
import ru.luxtington.oop.people.family.Boy;

@ToString(ToStringOption.YES)
@Default(DefaultValuesHolder.class)
public class
B extends A{
    public double bNum;

    public B() {
        super(0, null);
    }

    public B(int a, String b, double bNum) {
        super(a,b);
        this.bNum = bNum;
    }
}
