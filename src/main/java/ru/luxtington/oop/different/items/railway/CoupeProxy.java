package ru.luxtington.oop.different.items.railway;

import org.jetbrains.annotations.NotNull;

public class CoupeProxy extends Coupe{

    public CoupeProxy(@NotNull CoupePlace pl1, @NotNull CoupePlace pl2, @NotNull CoupePlace pl3, @NotNull CoupePlace pl4) {
        super(pl1, pl2, pl3, pl4);
    }

    @Override
    void addCustomerToCoupe(Customer customer){
        super.addCustomerToCoupe(customer);
        System.out.println(currPlaceNumber + " " + places.get(currPlaceNumber) + " was sold");
    }
}
