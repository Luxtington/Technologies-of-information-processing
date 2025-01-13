package ru.luxtington.oop.people.it;

public class PhpDeveloper implements Developer{
    @Override
    public String makeJob() {
        return "PHP dev writes php code";
    }

    public String toString(){
        return "PHP developer";
    }
}
