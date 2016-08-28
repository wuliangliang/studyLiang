package leetcode.reserch;

import org.junit.Test;

/**
 * Created by baidu on 16/7/13.
 */
public class BinarySercher {
//    public int guessNumber(int n) {
//
//    }


    @Test
    public void test(){
        System.out.println(getSum(9,9));
    }
    public int getSum(int a, int b) {
        while(b!=0)
        {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
