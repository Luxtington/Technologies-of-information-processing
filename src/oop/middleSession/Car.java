package oop.middleSession;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String title;
    private Engine engine;
    private int mileage;
    private final int maxFuelTank;
    private int currFuelTank;
    private List <Feature> features = new ArrayList<>();
    private int fuelConsumption;
    private List <Engine> engineList = new ArrayList<>();

    public Car(Engine engine, int maxFuelTank, String title, List <Engine> engines, List <Feature> features){
        setListEngines(engines);
        setEngine(engine);

        this.mileage = engine.getMileage();

        if (maxFuelTank < 1)
            throw new IllegalArgumentException("Max fuel tank can't be less than 1 liter");
        this.maxFuelTank = maxFuelTank;

        if (title.isBlank())
            throw new IllegalArgumentException("Incorrect car's title");
        this.title = title;

        if (features != null)
            this.features = new ArrayList<>(features);

    }

    public Car(Engine engine, int maxFuelTank, String title, List <Engine> engines){
        this(engine, maxFuelTank, title, engines, null);
    }

    public String getTitle(){
        return title;
    }

    public int refuelCar(int liters){ // returns unnecessary quantity of liters
        if (liters > maxFuelTank){
            currFuelTank = maxFuelTank;
            return liters - maxFuelTank;
        }
        currFuelTank = liters;
        return 0;
    }

    public void goByKilometers(int kilometers){
        if (currFuelTank < kilometers)
            throw new IllegalArgumentException("Too much kilometers for current fuel's level");
        currFuelTank -= kilometers;
        engine.addMileage(engine.getMileage() + kilometers);
        // 1 liter = 1 kilometer;
    }

    public void goByCoordinates(int begin, int end){
        goByKilometers(Math.abs(end - begin));
    }

    public void setEngine(Engine engine){
        if (engineList != null){
            if (checkEngine(engine)) this.engine = engine;
            else throw new IllegalArgumentException("This engine can't be installed in this car");
        }
        else
            throw new IllegalArgumentException("This engine can't be installed in this car"); // there is no info about engines
    }

    private boolean checkEngine(Engine engine){
        for (int i = 0; i < engineList.size(); i++){
            if (engine == engineList.get(i)) return true;
        }
        return false;
    }

    public List <Feature> getFeatures(){
        return new ArrayList<>(features);
    }

    public Feature getFeature(Feature feature){
        if (features.contains(feature))
            return feature;
        throw new IllegalArgumentException("There's no such feature in the car's features's list");
    }

    public void removeFeatureByIndex(int index){
        if (features.isEmpty())
            throw new IllegalArgumentException("There's no features to remove");
        features.remove(index);

    }

    public void installFeature(Feature feature){
        if (feature.checkCar(this))
            features.add(feature);
        else
            throw new IllegalArgumentException("This feature ins't allow for this car");
    }

    public void setListEngines(List <Engine> engines){
        if (engines != null)
            this.engineList = new ArrayList<>(engines);
        else
            throw new IllegalArgumentException("List of engines shouldn't be null");
    }

    public String toString(){
        String copyFeatures = (features.isEmpty())? "no" : features.toString();
        return title + ", " + engine + ", max fuel tank = " + maxFuelTank + " liters, features: " + copyFeatures;
    }
}
