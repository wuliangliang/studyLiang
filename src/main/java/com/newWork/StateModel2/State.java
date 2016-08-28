package com.newWork.StateModel2;

/**
 * Created by doubling on 16/8/7.
 */
public interface State {
    public void handlePush(Context context);

    public void handlePull(Context context);

    public String getColor();
}
