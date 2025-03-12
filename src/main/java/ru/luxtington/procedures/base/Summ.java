package ru.luxtington.procedures.base;

public class Summ
{
    public static void main(String[] args)
    {
        int result = 0;

        for (int i=0; i< args.length; i++)
        {
            result += Integer.parseInt(args[i]);
        }
        System.out.printf("Result = %d", result);
    }
}
