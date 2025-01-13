package ru.luxtington.oop.different.items.traffic;

public class YellowAfterGreenColor implements Color {

    private static final Color yellowAfterGreenColor = new YellowAfterGreenColor();

    public static Color createYellowAfterGreenColor(){
        return yellowAfterGreenColor;
    }

    private YellowAfterGreenColor() {
    }

    @Override
    public Color switchToNext() {
        return RedColor.createRedColor();
    }

    @Override
    public void shine() {
        System.out.println("yellow");
    }
}
