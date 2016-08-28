package leetcode.string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by baidu on 16/7/14.
 */
public class LargestNumber179 {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        if (n < 1) return "";

        String[] strs = new String[nums.length];
        for(int i = 0 ;i< n ; i++){
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Cmp());
        String ans = "";
        for (int i = n - 1; i >= 0; i--) {
            ans = ans.concat(strs[i]);
        }
        //去掉数字开头的0，如输入[0, 0]
        int i = 0;
        while (i < n && ans.charAt(i) == '0') {
            i++;
        }
        if (i == n) return "0";

        return ans.substring(i);
    }
}
class Cmp implements Comparator<String> {
    @Override
    public int compare(String a, String b) {
        String ab = a.concat(b);
        String ba = b.concat(a);
        return (int) (Long.parseLong(ab) - Long.parseLong(ba));
    }
}