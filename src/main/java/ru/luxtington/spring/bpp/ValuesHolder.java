package ru.luxtington.spring.bpp;

import org.springframework.stereotype.Component;

@Component
public class ValuesHolder {
    public int setIntAsDefault(){
        return 5;
    }

    public String setStringAsDefault(){
        return "qwerty";
    }

    public double setDoubleAsDefault(){
        return 12.34;
    }
}
