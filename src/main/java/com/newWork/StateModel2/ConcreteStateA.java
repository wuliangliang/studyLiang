package com.newWork.StateModel2;

import com.newWork.StateModal.*;

/**
 * Created by doubling on 16/8/7.
 */
public class ConcreteStateA implements State{
    @Override
    public void handlePush(final Context context)
    {
        System.out.print(this.getColor());

        final State state = new ConcreteStateB();
        context.setState(state);
        state.handlePush(context);
    }

    @Override
    public void handlePull(final Context context)
    {
        System.out.print(this.getColor());
    }

    @Override
    public String getColor()
    {
        return "RED";
    }
}
