package com.newWork.StateModel2;

/**
 * Created by doubling on 16/8/7.
 */
public class Context {
    private State state = null;

    public State getState()
    {
        return state;
    }

    public void setState(final State state)
    {
        this.state = state;
    }

    public void push()
    {
        state.handlePush(this);
    }

    public void pull()
    {
        state.handlePull(this);
    }
}
