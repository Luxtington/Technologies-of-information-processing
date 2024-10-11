package OOP.basicLessons.lesson1_1.classwork;

public class Stack
{
    public static int[] values = new int[100];
    public static int head = 0;

    public void push(int number)
    {
        if (head == values.length-1)
        {
            {
                System.out.println("Stack is full");
                return;
            }
        }
        values[head++] = number;
    }

    public void pop()
    {
        if (head == 0)
        {
            System.out.println("Stack is empty");
            return;
        }
        values[head--]=0;
    }

    public int peek()
    {
        return values[head-1];
    }

    public String printStack()
    {
        String stackStr = "";
        for (int i=head-1; i>=0; i--)
        {
            stackStr+=values[i];
            stackStr+=' ';
        }
        return stackStr;
    }
}
