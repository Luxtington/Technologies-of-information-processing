package ru.luxtington.oop.people.it;

public class SeniorJavaDeveloper extends DeveloperDecorator{

    public SeniorJavaDeveloper(Developer developer) {
        super(developer);
    }

    public String teachInterns(){
        return ", teaches java interns";
    }

    public String makeJob(){
        return super.makeJob() + teachInterns();
    }
}
