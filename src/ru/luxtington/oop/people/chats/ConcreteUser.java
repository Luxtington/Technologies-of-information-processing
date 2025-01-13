package ru.luxtington.oop.people.chats;

public class ConcreteUser extends User{
    public ConcreteUser(String name, Mediator mediator){
        super(name, mediator);
    }
    @Override
    void sendMessage(String message){
        System.out.println("User " + name + " wrote:" + message);
    }
    @Override
    void receiveMessage(String message){
        System.out.println("User " + name + " received:" + message);
    }
}
