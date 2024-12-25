package ru.luxtington.oop.people.studying;

public class AddMarkUpdate implements Update{

    private Integer mark;

    public AddMarkUpdate(Integer mark) {
        this.mark = mark;
    }

    @Override
    public void rollBack() {
    }
}
