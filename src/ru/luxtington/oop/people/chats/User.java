package ru.luxtington.oop.people.chats;

import org.jetbrains.annotations.NotNull;

public abstract class User {
    String name;
    Mediator mediator;

    public User(@NotNull String name, @NotNull Mediator mediator){
        this.name = name;
        this.mediator = mediator;
    }

    abstract void sendMessage(String message);
    abstract void receiveMessage(String message);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "User with name " + name;
    }
}
