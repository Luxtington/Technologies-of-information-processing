package ru.luxtington.oop.different.items.my;

import java.util.*;

public class MyCar {

    private String color;
    private double weight;
    private int wheels;

    private static Map<CarBuilder, MyCar> allMyCars = new HashMap<>();

    private MyCar(CarBuilder builder){
        this.color = builder.color;
        this.weight = builder.weight;
        this.wheels = builder.wheels;
    }

    public static class CarBuilder{
        private String color;
        private double weight;
        private int wheels;

        public CarBuilder setColor(String color){
            this.color = color;
            return this;
        }

        public CarBuilder setWeight(double weight){
            this.weight = weight;
            return this;
        }

        public CarBuilder setWheels(int wheels){
            this.wheels = wheels;
            return this;
        }

        public MyCar build(){
            /*MyCar res = allMyCars.stream().filter(x -> x.weight == this.weight &&
                            x.wheels == this.wheels &&
                            x.color == this.color)
                    .findFirst()
                    .orElse(null);
            if (res != null)
                return res;   if we have ArrayList of Cars, we should use stream
                */

            if (allMyCars.containsKey(this))
                return allMyCars.get(this);

            MyCar newMyCar = new MyCar(this);
            allMyCars.put(this, newMyCar);
            return newMyCar;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof CarBuilder that)) return false;
            return Double.compare(weight, that.weight) == 0 && wheels == that.wheels && Objects.equals(color, that.color);
        }

        @Override
        public int hashCode() {
            return Objects.hash(color, weight, wheels);
        }
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyCar myCar = (MyCar) o;
        return color == myCar.color && weight == myCar.weight && wheels == myCar.wheels;
    }

    @Override
    public int hashCode(){
        return Objects.hash(color, weight, wheels);
    }

    public String toString(){
        return "Car with " + "wheels: " + wheels
                + ", color - " + color + ", weight = " + weight;
    }
}

