package ru.luxtington.main;

import ru.luxtington.oop.different.animals.birds.Bird;
import ru.luxtington.oop.different.animals.cats.Meowable;
import ru.luxtington.oop.geometry.figures.Figure;
import ru.luxtington.oop.geometry.figures.Lengthable;
import ru.luxtington.oop.geometry.figures.Polyline;
import ru.luxtington.oop.geometry.figures.Polylineable;
import ru.luxtington.oop.geometry.points.Point2D;
import ru.luxtington.oop.people.gunner.Shooter;
import ru.luxtington.oop.people.studying.IncorrectMarkException;
import ru.luxtington.oop.people.studying.Student;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;
import static java.lang.Integer.*;

public class Tester {
    public static double summ(Number...numbers){
        double summ = 0;

        for (int i=0; i < numbers.length; i++)
            summ += numbers[i].doubleValue();

        return summ;
    }

    public static double summAreas(Figure...figures){
        double res = 0;

        for (int i=0; i < figures.length; i++)
            res += figures[i].area();

        return res;
    }

    public static int summLength(Lengthable... objs){
        int res = 0;

        for (int i=0; i < objs.length; i++)
            res += objs[i].length();

        return res;
    }

    public static void hearSongs(Bird...birds){
        for (int i=0; i < birds.length; i++)
            birds[i].sing();
    }

    public static void hearMeow(Meowable...objects){
        for (int i=0; i < objects.length; i++)
            objects[i].makeMeow();
    }

    public static Polyline<Point2D> joinPolylines(Polylineable...shapes){
        List<Point2D> points = new ArrayList<>();
        int index = 0;

        for (int i=0; i < shapes.length; i++){
            for (int j=0; j < shapes[i].getPolyline().points.size(); j++){
                points.add((Point2D) shapes[i].getPolyline().points.get(j));
            }
        }
        return new Polyline(points);
    }

    public static void hearShooter(Shooter sh){
        sh.shoot();
    }

    public static double toPower(String x, String y){
        return pow(parseInt(x), parseInt(y));
    }

    public static void setMarkToStudents(List <Student> students, int mark){

        int index = 0;
        try{
            for (index=0; index < students.size(); index++)
                students.get(index).addMark(mark);
        }
        catch (IncorrectMarkException e){
            for (int i=0; i < index; i++)
                students.get(i).removeMark(mark);
        }
    }
}
