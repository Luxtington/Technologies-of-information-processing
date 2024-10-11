package OOP.basicLessons.lesson1_4.homework;

public class Time
{
    private int hours;
    private int minutes;
    private int seconds;

    public Time(int seconds)
    {
        this.seconds = seconds;
    }

    public Time(int hours, int minutes, int seconds)
    {
        this(hours*3600 + minutes*60 + seconds);
    }

    public int getHour()
    {
        int currHours =  seconds/3600;
        if (currHours > 24) currHours-=24;
        return currHours;
    }

    public int getMinutes()
    {
        return (seconds - this.getHour()*3600)/60;
    }

    public int getSeconds()
    {
        return seconds - this.getHour()*3600 - this.getMinutes()*60;
    }

    public String toString()
    {
        int copyHours = this.getHour();
        int copyMinutes = this.getMinutes();
        int copySeconds = this.getSeconds();

        return copyHours + ":" + copyMinutes + ":" + copySeconds;
    }
}
