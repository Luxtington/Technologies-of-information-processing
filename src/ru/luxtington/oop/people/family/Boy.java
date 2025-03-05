package ru.luxtington.oop.people.family;

import ru.luxtington.annotations.Invoke;
import ru.luxtington.annotations.LikeValidator;

@LikeValidator
public class Boy {
    private int age;
    private String name;
    private int parentsQuantity;

    public Boy(int age, String name, int parentsQuantity) {
        this.age = age;
        this.name = name;
        this.parentsQuantity = parentsQuantity;
    }

    public Boy() {
    }

    @Invoke
    public int getAge() {
        return age;
    }

    @Invoke
    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Invoke
    public int getParentsQuantity() {
        return parentsQuantity;
    }

    public void setParentsQuantity(int parentsQuantity) {
        this.parentsQuantity = parentsQuantity;
    }

    @Invoke
    private String sayHallo(){
        return "Hallo, I'm a boy";
    }

    @Invoke
    @Override
    public String toString() {
        return getClass().getName() + '{' +
                "age=" + age +
                ", name='" + name + '\'' +
                ", parentsQuantity=" + parentsQuantity +
                '}';
    }
}
