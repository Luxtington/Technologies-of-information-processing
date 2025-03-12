package ru.luxtington.oop.people.it;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Team implements Developer{
    private List<Developer> devs = new ArrayList<>();

    private String createProject(){
        System.out.println("Team of developers is ready to create project." + System.lineSeparator());
        StringBuilder actions = new StringBuilder();

        for (Developer dev : devs)
            actions.append(dev.makeJob() + System.lineSeparator());

        return actions.toString();
    }

    @Override
    public String makeJob() {
        return createProject();
    }

    public void addDeveloper(@NotNull Developer dev){
        devs.add(dev);
    }

    public void removeDeveloper(@NotNull Developer dev){
        devs.remove(dev);
    }

    public String toString(){
        StringBuilder res = new StringBuilder();

        for (Developer dev : devs)
            res.append(dev + " ");

        return res.toString();
    }
}
