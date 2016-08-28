package com.newWork.StateMachine;

/**
 * Created by doubling on 16/8/7.
 */

import static com.newWork.StateMachine.Print.pln;

/**
 * 空调Aircon。简单的模型：
 * 遥控器有两个按钮(更多的按钮在下面的例子中引入)，power电源键和cool制冷键。
 * 空调的运行呈现3个状态，停止/Off、仅送风/FanOnly、制冷/Cool。
 * 起始状态为Off
 * @author (yqj2065)
 * @version 0.1
 */
public class Aircon0 {
    // off，FanOnly，AC
    private int state = 0;//起始状态为Off

    public int getState() {
        return state;
    }

    //两个Action
    public void power() {//按power键
        if (state == 0) {//off
            state = 1;
            pln("start Fan");
        } else if (state == 1) {//FanOnly
            state = 0;
            pln("stop Fan");
        } else {
            state = 0;
            pln("stop Cool");
        }
    }

    public void cool() {//按制冷键
        if (state == 0) {//off
            pln("nothing");
        } else if (state == 1) {//FanOnly
            state = 2;
            pln("start Cool");
        } else {
            state = 1;
            pln("stop Cool");
        }
    }
}