package ru.luxtington.oop.different.items.traffic;

public class GreenColor implements Color{

    private static final Color greenColor = new GreenColor();

    public static Color createGreenColor(){
        return greenColor;
    }

    private GreenColor() {
    }

    @Override
    public Color switchToNext() {
        return YellowAfterGreenColor.createYellowAfterGreenColor();
    }

    @Override
    public void shine() {
        System.out.println("green");
    }
}
