package ru.luxtington.oop.people.chats;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ChatMediator implements Mediator {
    private List<User> users = new ArrayList<>();
    public void addUser(@NotNull User user){
        users.add(user);
    }
    @Override
    public void sendMessageToChat(User user, String message){
        user.sendMessage(message);
        for (User u : users){
            if (u != user)
                u.receiveMessage(message);
        }
    }
}
