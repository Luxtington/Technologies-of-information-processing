package ru.luxtington.oop.different.cities;

import java.util.List;

public class SmartCity extends City {

    public SmartCity(String title, List<Way> ways)
    {
        super(title, ways);
    }

    public SmartCity(String title)
    {
        super(title);
    }

    @Override
    public void addWay(Way newWay)
    {
        //System.out.println("1 - child");
        super.addWay(newWay);
        for (int i=0; i < newWay.city.getWays().size(); i++)
        {
            if (newWay.city.getWays().get(i).city == this)
                return;
        }
        newWay.city.addWay(new Way(this, newWay.getCost()));
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
