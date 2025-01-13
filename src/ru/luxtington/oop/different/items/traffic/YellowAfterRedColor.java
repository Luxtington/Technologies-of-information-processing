package ru.luxtington.oop.different.items.traffic;

public class YellowAfterRedColor implements Color{

    private static final Color yellowAfterRedColor = new YellowAfterRedColor();

    public static Color createYellowAfterRedColor(){
        return yellowAfterRedColor;
    }

    private YellowAfterRedColor() {
    }

    @Override
    public Color switchToNext() {
        return GreenColor.createGreenColor();
    }

    @Override
    public void shine() {
        System.out.println("yellow");
    }
}
