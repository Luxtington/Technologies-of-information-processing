package oop.geometricShapes.interestingPoint;

import java.util.ArrayList;
import java.util.List;

public class PointUniversal {

    public int x;
    private List<Attribute> attributes = new ArrayList<>();

    public PointUniversal(int x, List<Attribute> attributes){
        this.x = x;
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
        return "Point in x = " + x + ", with attributes: " + attributes.toString();
    }

}
