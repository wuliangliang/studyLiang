package com.newWork.StateModal;

/**
 * Created by doubling on 16/8/7.
 */

public class GreenState extends State {


    public void handlepush(Context c) {
        System.out.println("变成黑色");
                c.setState(new BlackState());
       }

    public void handlepull(Context c) {
        System.out.println("变成蓝色");
               c.setState(new BlueState());
        }

    public Color getColor() {
        return (Color.green);
    }
}