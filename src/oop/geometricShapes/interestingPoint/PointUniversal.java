package oop.geometricShapes.interestingPoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PointUniversal {

    public int [] coordinates = new int[3];
    private List<Attribute> attributes = new ArrayList<>();

    public PointUniversal(int [] coordinates, List<Attribute> attributes){
        this.coordinates = coordinates;
        this.attributes = attributes;
    }

    public List<Attribute> getAttributes(){
        return new ArrayList<>(attributes);
    }

    public void addAttribute(Attribute newAttribute){

        for (int i=0; i < attributes.size(); i++){
            if (attributes.get(i).equals(newAttribute))
                throw new IllegalArgumentException("This attribute already exists");
        }
        attributes.add(newAttribute);
    }

    public void removeAttribute(Attribute delAttribute){

        if (!(attributes.contains(delAttribute)))
            throw new IllegalArgumentException("This attribute doesn't exist");
        attributes.remove(delAttribute);
    }

    public String toString(){
        return "Point in coordinates: " + Arrays.toString(coordinates) + ", with attributes: " + attributes.toString();
    }

}
