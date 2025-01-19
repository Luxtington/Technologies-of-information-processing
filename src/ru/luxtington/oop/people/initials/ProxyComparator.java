package ru.luxtington.oop.people.initials;

import java.util.Comparator;
import java.util.Objects;

public class ProxyComparator implements Comparator<Initial> {

    private Initial initial;
    private int hash = 0;

    public ProxyComparator(Initial initial) {
        this.initial = initial;
        hash = Objects.hash(initial.surname, initial.name, initial.patronymic);
    }

    @Override
    public int compare(Initial o1, Initial o2) {
        if (Objects.hash(o2.surname, o2.name, o2.patronymic) == hash)
            System.out.println("\nYes, it is\n");
        return  (Objects.hash(o1.surname, o1.name, o1.patronymic)
                -  Objects.hash(o2.surname, o2.name, o2.patronymic));
    }
}
