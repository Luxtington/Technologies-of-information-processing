package oop.differentThings.animals;

public class Bot implements Meowable{

    public String name;

    public Bot(String name) {
        this.name = name;
    }

    public void makeMeow(int times){
        String res = name + ": ";

        for (int i=0; i < times; i++)
            res += "MEOW!!!";

        System.out.println(res);
    }

    @Override
    public void makeMeow(){
        makeMeow(1);
    }

    public String toString() {
        return "Bot name = " + name;
    }
}
