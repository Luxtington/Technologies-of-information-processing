package ru.luxtington.oop.different.items.temperature;

enum TemperatureState {

    COLD(-50, 10, "cold"),
    NORMAL(10, 25, "normal"),
    HOT(25, 60, "hot");

    public final String title;
    protected int upBorder;
    protected int lowBorder;

    TemperatureState(int lowBorder, int upBorder, String title) {
        this.upBorder = upBorder;
        this.lowBorder = lowBorder;
        this.title = title;
    }
}
