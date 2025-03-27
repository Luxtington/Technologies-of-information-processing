package ru.luxtington.spring.beans;

public class Feedback {
    private String text;
    private int mark;

    public Feedback(String text, int mark) {
        this.text = text;
        this.mark = mark;
    }

    public int getMark() {
        return mark;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "text='" + text + '\'' +
                ", mark=" + mark +
                '}';
    }
}
