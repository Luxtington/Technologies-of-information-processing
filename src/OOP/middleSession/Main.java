package OOP.middleSession;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Engine e1 = new Engine("V300", 100), e2 = new Engine("V400", 300);
        Engine e3 = new Engine("V200", 0), e4 = new Engine("V500", 5000);
        Engine e5 = new Engine("V404", 404);

        List <Engine> engines1 = new ArrayList<>(Arrays.asList(e1, e2, e3, e4));


        Car car1 = new Car(e1, 50, "BMW", engines1), car2 = new Car(e4, 70, "Audi", engines1);


        Feature f1 = new Feature("Fly", new ArrayList<>(Arrays.asList(car1, car2)));

        Car car3 = new Car(e4, 30, "Schoda", engines1);

        car1.refuelCar(51);
        car1.goByCoordinates(1, 49);

        car1.installFeature(f1);
        car1.setEngine(e3);

        //car1.removeFeatureByIndex(0); - ok
        System.out.println(car1.getFeatures());



        System.out.println(car1);
        //System.out.println(e1.getMileage());// mileage should be greater - ok


        //car3.installFeature(f1); exc because unsupported feature - ok
        //car1.setEngine(e5); exc because unsupported engine - ok


    }
}
