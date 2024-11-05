package oop.middleSession;

import java.util.ArrayList;
import java.util.List;

public class Feature {
    private String title;
    private List<Car> requiredCars = new ArrayList<>();

    public Feature(String title, List<Car> requiredCars){
        if (title.isBlank())
            throw new IllegalArgumentException("Incorrect feature's title");
        this.title = title;

        if (requiredCars != null)
            this.requiredCars = new ArrayList<>(requiredCars);
    }

    public boolean checkCar(Car car){
        return requiredCars.contains(car);
    }

    public String toString(){
        String reqCars = "";
        for (int i=0; i < requiredCars.size(); i++)
            reqCars += requiredCars.get(i).getTitle();
        return "Feature: " + title + ", required cars: " + reqCars;
    }
}
