package com.newWork.StateModel2;

/**
 * Created by doubling on 16/8/7.
 */
public class ConcreteStateB implements State{
    @Override
    public void handlePush(final Context context)
    {
        System.out.print(this.getColor());

        final State state = new ConcreteStateC();
        context.setState(state);
        state.handlePush(context);

    }

    @Override
    public void handlePull(final Context context)
    {
        System.out.print(this.getColor());

        final State state = new ConcreteStateA();
        context.setState(state);
        state.handlePull(context);
    }

    @Override
    public String getColor()
    {
        return "YELLOW";
    }
}
