package ru.luxtington.oop.different.items.railway;

import org.jetbrains.annotations.NotNull;

public class BoxOffice {

    public static void sellTicketToCoupe(@NotNull Coupe coupe, @NotNull Customer customer){
        if (coupe.coupePeople.isEmpty()){
            coupe.addCustomerToCoupe(customer);
            coupe.coupeGender = customer.gender;
        }
        else{
            if (coupe.coupeGender != customer.gender)
                throw new IllegalArgumentException("People of different genders can't be together in the same coupe");
            coupe.addCustomerToCoupe(customer);
        }
    }
}
