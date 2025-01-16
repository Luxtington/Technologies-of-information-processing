package ru.luxtington.oop.different.items.railway;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Coupe {
    List<CoupePlace> places;
    Gender coupeGender;
    List<Customer> coupePeople = new ArrayList<>();
    int currPlaceNumber = 0;

    public Coupe(@NotNull CoupePlace pl1, @NotNull CoupePlace pl2, @NotNull CoupePlace pl3, @NotNull CoupePlace pl4) {
        int low = 0, up = 0;
        List<CoupePlace> tmp = List.of(pl1, pl2, pl3, pl4);
        for (CoupePlace pl : tmp){
            if (pl.location == Location.UP_PLACE) up++;
            else low ++;
        }
        if (!(up == 2 && low == 2))
            throw new IllegalArgumentException("There are should be accurate 2 up and 2 low places in the coupe");
        if (!((Math.abs(pl2.number - pl1.number) == 1  && Math.abs(pl3.number - pl2.number) == 1 && Math.abs(pl4.number - pl3.number) == 1)))
            throw new IllegalArgumentException("Place's numbers should be a right sequence");
        this.places = tmp;
    }

    void addCustomerToCoupe(Customer customer){
        if (coupePeople.size() == 4)
            throw new UnsupportedOperationException("Coupe is full. There are no free places");
        coupePeople.add(customer);
        currPlaceNumber = coupePeople.size() - 1;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder("Coupe with places:" + System.lineSeparator());

        for (int i=0; i < places.size(); i++){
            String pers = (i >= coupePeople.size()) ? "empty" : coupePeople.get(i) + "";

            res.append(places.get(i) + " - " + pers + ";" + System.lineSeparator());
        }

        return res.toString();
    }
}
