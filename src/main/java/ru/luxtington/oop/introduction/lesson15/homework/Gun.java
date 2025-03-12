package ru.luxtington.oop.introduction.lesson15.homework;

public class Gun
{
    private int bullets;

    public Gun(int bullets)
    {
        if (bullets<0)
            throw new IllegalArgumentException("Incorrect value of bullets");
        this.bullets = bullets;
    }

    public Gun()
    {
        this(5);
    }

    public int getBullets()
    {
        return bullets;
    }

    public void setBullets()
    {
        if (bullets<0)
            throw new IllegalArgumentException("Incorrect value of bullets");
        this.bullets = bullets;
    }

    public void makeShot()
    {
        if (bullets > 0)
        {
            System.out.println("Bax!");
            bullets--;
        }
        else
            System.out.println("Klac!");
    }
}
