package ru.luxtington.oop.different.items.traffic;

public class RedColor implements Color{

    private static final Color redColor = new RedColor();

    public static Color createRedColor(){
        return redColor;
    }

    private RedColor() {
    }

    @Override
    public Color switchToNext() {
        return YellowAfterRedColor.createYellowAfterRedColor();
    }

    @Override
    public void shine() {
        System.out.println("red");
    }
}
