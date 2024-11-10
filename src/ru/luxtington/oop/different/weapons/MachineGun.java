package ru.luxtington.oop.different.weapons;

public class MachineGun extends Gun {
    private final int firingRate;

    public MachineGun(int maxBullets, int firingRate)
    {
        super(maxBullets);
        if (firingRate < 1)
            throw new IllegalArgumentException("Firing rate should be greater than 0");
        this.firingRate = firingRate;
    }

    public MachineGun(int maxBullets)
    {
        this(maxBullets, maxBullets/2);
    }

    public MachineGun()
    {
        this(30, 30);
    }

    /*private void setFiringRate(int firingRate)
    {
        if (firingRate < 1)
            throw new IllegalArgumentException("Firing rate should be greater than 0");
        this.firingRate = firingRate;
    }*/

    @Override
    public void makeShot()
    {
        for (int i=0; i < firingRate; i++)
            super.makeShot();
    }

    public void makeShot(int seconds)
    {
        for (int i=0; i < seconds; i++)
            this.makeShot();
    }
}
