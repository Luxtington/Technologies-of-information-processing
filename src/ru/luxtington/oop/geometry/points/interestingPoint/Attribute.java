package ru.luxtington.oop.geometry.points.interestingPoint;

public abstract class Attribute {

    private String title;
    private Object value;

    public Attribute(String title, Object value){
        this.title = title;
        this.value = value;
    }

    public String getTitle(){
        return title;
    }

    public Object getValue(){
        return value;
    }

    public String toString(){
        return title + ": " + value;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null)
            return false;

        if (this.getClass() != obj.getClass())
            return false;

        final Attribute attribute = (Attribute) obj;
        return (this.title == attribute.getTitle() && this.value == attribute.getValue());  // ??
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.title != null ? this.title.hashCode() : 0);
        hash = 53 * hash + (int)this.value;
        return hash;
    }
}
