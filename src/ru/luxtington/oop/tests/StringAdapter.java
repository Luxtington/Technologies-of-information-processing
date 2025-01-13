package ru.luxtington.oop.tests;

import ru.luxtington.oop.geometry.figures.Lengthable;

class StringAdapter extends Number implements Lengthable {

    private String str;

    public StringAdapter(String str) {
        this.str = str;
    }

    @Override
    public int intValue() {
        return str.length();
    }

    @Override
    public long longValue() {
        return str.length();
    }

    @Override
    public float floatValue() {
        return str.length();
    }

    @Override
    public double doubleValue() {
        return str.length();
    }

    @Override
    public int length() {
        return str.length();
    }
}
