package com.newWork.StateModel2;

/**
 * Created by doubling on 16/8/7.
 */
public class Client {
    public static void main(final String[] args)
    {
        // YTODO Auto-generated method stub
        final Context context = new Context();
        context.setState(new ConcreteStateA());
        System.out.println("PUSH:");
        context.push();
        System.out.println("\nPULL:");
        context.pull();
    }
}
