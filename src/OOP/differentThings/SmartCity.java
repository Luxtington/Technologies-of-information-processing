package OOP.differentThings;

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
        System.out.println("1 - child");
        super.addWay(newWay);
        newWay.getCity().addWay(new Way(this, newWay.getCost()));
    }


}
