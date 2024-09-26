package OOP.lesson1.homework;

public class Time
{
    private int seconds;

    public Time(int seconds)
    {
        if (seconds < 0) throw new IllegalArgumentException("Incorrect value of seconds");
        this.seconds = seconds;
    }

    public void setSeconds(int seconds)
    {
        if (seconds < 0) throw new IllegalArgumentException("Incorrect value of seconds");
        this.seconds = seconds;
    }

    public int getSeconds()
    {
        return seconds;
    }

    public String toString()
    {
        int hours = seconds/3600;
        int minutes = (seconds - hours*3600)/60;
        int copySeconds = seconds - hours*3600 - minutes*60;

        if (hours > 24) hours-=24;

        return hours + ":" + minutes + ":" + copySeconds;
    }
}
