package oop.peopleWithTheirItems;

import oop.differentThings.weapons.Weapon;

public class Shooter {
    public String name;
    public Weapon weapon;

    public Shooter(String name) {
        this.name = name;
    }

    public void shoot(){
        if (weapon == null){
            System.out.println("I can't shoot");
            return;
        }
        weapon.makeShot();
    }
}
