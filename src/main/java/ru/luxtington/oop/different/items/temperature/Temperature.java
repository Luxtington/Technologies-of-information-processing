package ru.luxtington.oop.different.items.temperature;

import java.util.HashMap;
import java.util.Map;

public class Temperature {

    private TemperatureState state;
    private static Map<Integer, Temperature> temperatures = new HashMap<>();

    private Temperature(int degrees) {

        if (TemperatureState.COLD.lowBorder <= degrees && degrees <= TemperatureState.COLD.upBorder){
            this.state = TemperatureState.COLD;
        }

        else if (TemperatureState.NORMAL.lowBorder <= degrees && degrees <= TemperatureState.NORMAL.upBorder) {
            this.state = TemperatureState.NORMAL;
        }

        else if (TemperatureState.HOT.lowBorder <= degrees && degrees <= TemperatureState.HOT.upBorder){
            this.state = TemperatureState.HOT;
        }

        else
            throw new IllegalArgumentException("Incorrect value of temperature");

        temperatures.put(degrees, this);
    }

    public static Temperature createTemperatute(int degrees){

        if (temperatures.containsKey(degrees))
            return temperatures.get(degrees);

        Temperature newT = new Temperature(degrees);
        return newT;
    }

    public String toString(){
        return state.title;
    }
}
