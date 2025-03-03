package ru.luxtington.main;

import ru.luxtington.oop.people.family.Child;
import ru.luxtington.oop.people.family.IllegalMarkException;
import ru.luxtington.oop.people.family.Parent;
import ru.luxtington.oop.people.family.Swearing;
import ru.luxtington.oop.people.initials.Initial;
import ru.luxtington.oop.people.initials.ProxyComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Initial name1 =  Initial.of("Ivanov", "Ivan", "Ivanovich");
        Initial name2 =  Initial.of("Ivan", "Ivanov", "Ivanovich");
        Initial name3 =  Initial.of("I", "Ivav", "noich");
        Initial name4 =  Initial.of("Ivn", "Ivnov", "Ivvich");
        Initial name5 =  Initial.of("n", "Ivnov", "Ivanovich");
        Initial name6 =  Initial.of("I", "Ivov", "Ivan");

        List<Initial> lst = new ArrayList<>(Arrays.asList(name1, name2, name3, name4, name5, name6));

        lst.sort(new ProxyComparator(name1));

        System.out.println(lst);
    }
}