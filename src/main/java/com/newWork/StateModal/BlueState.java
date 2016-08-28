package com.newWork.StateModal;

import clojure.lang.Compiler;

/**
 * Created by doubling on 16/8/7.
 */
public class BlueState extends State{

    public void handlepush(Context c){
        System.out.println("变成绿色");
         c.setState(new GreenState());
        }

    public void handlepull(Context c) {
        System.out.println("变成红色");
        c.setState(new RedState());
    }

    @Override
    public Color getColor() {
        return Color.blue;
    }


}