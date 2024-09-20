package ProcedureTasks;

public class ArrayHelper
{
    public static int sumElements(int [] array)
    {
        int sum = 0;

        for (int i=0; i < array.length; i++)
            sum += array[i];

        return sum;
    }

    public static void nullNegative(int [] array)
    {
        for (int i=0; i < array.length; i++)
        {
            if (array[i] < 0)
                array[i] = 0;
        }
    }

    public static int [] addToEnd(int [] array, int number)
    {
        int [] newArray = new int[array.length + 1];
        for (int i=0; i < newArray.length; i++)
        {
            if (i == newArray.length - 1)
                newArray[i] = number;
            else
                newArray[i] = array[i];
        }
        return newArray;
    }

    public static int [] addByIndex(int [] array, int index, int number)
    {
        if (index < 0 || index > array.length-1) throw new IllegalArgumentException("Incorrect value of index");

        int [] newArr = new int[array.length + 1];
        for (int i=0; i< array.length; i++)
            newArr[i] = array[i];

        for (int i = newArr.length - 1; i > index; i--)
            newArr[i] = newArr[i-1];

        newArr[index] = number;

        return newArr;
    }
}
