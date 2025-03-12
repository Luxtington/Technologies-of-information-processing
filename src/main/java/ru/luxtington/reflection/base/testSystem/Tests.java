package ru.luxtington.reflection.base.testSystem;


import ru.luxtington.oop.geometry.figures.Polyline;
import ru.luxtington.oop.geometry.points.Point2D;

import java.util.List;

//List<Method> failedMethods = new ArrayList<>();
//Map<Method, String> failedMethods = new HashMap<>();
//failedMethods.put(getClass().getMethod("polylineTest"), "Length should be greater than 5");

public class Tests {

    public Tests() {
    }

    void polylineTest() throws TestValidationException{
        Polyline<Point2D> p = new Polyline<>(List.of(new Point2D(1,2),
                new Point2D(3,4), new Point2D(5,6)));


        var res = p.length();

        if (res != 5)
            throw new TestValidationException("Length of polyline should be greater than 5");

    }

    void pointTest() throws TestValidationException{
        Point2D p = new Point2D(-5,-6);

        if (p.x < 0 && p.y < 0)
            throw new TestValidationException("Point's coords should be positive");

    }
}
