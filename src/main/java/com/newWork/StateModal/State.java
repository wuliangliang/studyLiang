package com.newWork.StateModal;

/**
 * Created by doubling on 16/8/7.
 */
public abstract class State {
    public abstract void handlepush(Context c);
    public abstract void handlepull(Context c);
    public abstract Color getColor();
}
