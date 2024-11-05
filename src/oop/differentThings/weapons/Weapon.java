package oop.differentThings.weapons;

public abstract class Weapon {

    private int currBullets;

    public Weapon(int currBullets){
        if (currBullets < 0)
            throw new IllegalArgumentException("Incorrect value of bullets");
        this.currBullets = currBullets;
    }

    public int getCurrBullets(){
        return currBullets;
    }

    public boolean isEmpty() {
        return currBullets == 0;
    }

    public boolean removeBullet(){
        if (currBullets > 0){
            currBullets--;
            return true;
        }
        return false;
    }

    public void loadBullets(int bullets){
        if (bullets < 0)
            throw new IllegalArgumentException("Incorrect value of loaded bullets");
        currBullets += bullets;
    }

    public abstract void makeShot();
}
