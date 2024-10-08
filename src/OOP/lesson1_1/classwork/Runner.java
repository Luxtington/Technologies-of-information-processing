package OOP.lesson1_1.classwork;

public class Runner
{
    public static void main(String[] args)
    {
        Stack st1 = new Stack();

        st1.push(15);
        st1.push(3);
        st1.push(42);

        System.out.printf("The current head of stack = %d\n", st1.peek());

        st1.pop();

        System.out.println(st1.printStack());
    }
}
