package com.newWork.StateModal;

/**
 * Created by doubling on 16/8/7.
 */

public class BlackState extends State{

    public void handlepush(Context c) {
        System.out.println("变成红色");
        c.setState(new RedState());
    }

    public void handlepull(Context c){
        System.out.println("变成红色");
               c.setState(new RedState());
        }

    public  Color getColor(){
        return (Color.black);
    }
}