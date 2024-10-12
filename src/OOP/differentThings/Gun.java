package OOP.differentThings;

public class Gun
{
    private int currBullets = 0;
    private final int maxBullets;

    public Gun(int maxBullets)
    {
        if (maxBullets < 0)
            throw new IllegalArgumentException("Incorrect value of bullets");
        this.maxBullets = maxBullets;
    }

    public Gun()
    {
        this(5);
    }

    public int getMaxBullets()
    {
        return maxBullets;
    }

    public int getCurrBullets()
    {
        return currBullets;
    }

    public int loadBullets(int bullets)
    {
        if (bullets <0)
            throw new IllegalArgumentException("Incorrect value of bullets");

        if (bullets + currBullets > maxBullets)
        {
            currBullets = maxBullets;
            return currBullets+bullets-maxBullets; // return excess bullets
        }

        currBullets += bullets;
        return 0;
    }

    public int removeBullets()
    {
        int copyBullets = currBullets;
        currBullets = 0;
        return copyBullets;
    }

    public boolean isEmpty()
    {
        return currBullets == 0;
    }

    public void makeShot()
    {
        if (this.isEmpty())
            System.out.println("Klac!");
        else
        {
            System.out.println("Bax!");
            currBullets--;
        }
    }
}
