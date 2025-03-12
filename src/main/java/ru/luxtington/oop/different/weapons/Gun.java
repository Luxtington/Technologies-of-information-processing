package ru.luxtington.oop.different.weapons;

public class Gun extends Weapon {
    private final int maxBullets;

    public Gun(int maxBullets) {
        super(0);
        if (maxBullets < 0)
            throw new IllegalArgumentException("Incorrect value of bullets");
        this.maxBullets = maxBullets;
    }

    public Gun() {
        this(5);
    }

    public int getMaxBullets() {
        return maxBullets;
    }

    /*public int loadBullets(int bullets) {
        if (bullets < 0)
            throw new IllegalArgumentException("Incorrect value of bullets");

        if (bullets + currBullets > maxBullets) {
            currBullets = maxBullets;
            return currBullets + bullets - maxBullets; // return excess bullets
        }

        currBullets += bullets;
        return 0;
    }*/

    /*public int removeBullets() { // возвращает число изъятых патронов
        int copyBullets = currBullets;
        currBullets = 0;
        return copyBullets;
    }*/

    public void makeShot() {
        if (this.isEmpty())
            System.out.println("Klac!");
        else {
            System.out.println("Bax!");
            removeBullet();
        }
    }
}
