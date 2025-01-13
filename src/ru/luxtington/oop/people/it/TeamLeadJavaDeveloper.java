package ru.luxtington.oop.people.it;

public class TeamLeadJavaDeveloper extends DeveloperDecorator{

    public TeamLeadJavaDeveloper(Developer developer) {
        super(developer);
    }

    public String checkDecisions(){
        return ", checks decisions";
    }

    public String makeJob(){
        return super.makeJob() + checkDecisions();
    }
}
