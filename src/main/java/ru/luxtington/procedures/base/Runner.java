package ru.luxtington.procedures.base;

import java.util.Arrays;

public class Runner
{
    public static void main(String[] args)
    {
        int [] array1 = {-1,2,3,4,-5}, array2 = {-5, -7, 98, 1, 404, 777};
        int [] array3 = {1,4,8,9,23}, array4 = {4, 9, 67, 54, 32, 90};

        ArrayHelper.nullNegative(array2);
        array3 = ArrayHelper.addToEnd(array3, 99);
        array4 = ArrayHelper.addByIndex(array4, 0, 999);

        System.out.printf("Sum of array elements = %d\n", ArrayHelper.sumElements(array1));
        System.out.println("Result of null of negative array elements = " + Arrays.toString(array2));
        System.out.println("Result of adding to end of the array a number = " + Arrays.toString(array3));
        System.out.println("Result of adding a number by the index of the array = " + Arrays.toString(array4));
    }
}
