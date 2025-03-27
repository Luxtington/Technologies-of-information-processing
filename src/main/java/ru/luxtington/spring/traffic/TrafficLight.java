package ru.luxtington.spring.traffic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TrafficLight {
    private Color currColor;

    @Autowired
    public TrafficLight(@Qualifier("redColor") Color currColor) {
        this.currColor = currColor;
    }

    public void next(){
        currColor.shine();
        currColor = currColor.switchToNext();
    }
}
