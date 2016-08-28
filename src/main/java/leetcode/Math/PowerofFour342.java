package leetcode.Math;

/**
 * Created by baidu on 16/7/14.
 */
public class PowerofFour342 {
    public boolean isPowerOfFour(int num) {
        if(num == 1)  // 单独处理数字1
            return true;

        while(num % 4 == 0 && num != 0) {
            num = num / 4;
            if(num == 1)
                return true;
        }

        return false;



        //return num > 0 && (num & (num - 1)) == 0 && (num - 1) % 3 == 0;



    }
}
