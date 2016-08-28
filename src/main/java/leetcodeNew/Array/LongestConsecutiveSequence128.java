package leetcodeNew.Array;

import java.util.Arrays;

/**
 * Created by baidu on 16/8/5.
 */
public class LongestConsecutiveSequence128 {
    public int longestConsecutive(int[] num) {
        Arrays.sort(num);
        int sum =1;
        int count = 1 ;
        for(int i = 1 ; i< num.length;i++){
            if(num[i]==num[i-1]+1){
                count++;
                sum = Math.max(sum,count);
            }
            else if((num[i]!=num[i-1])&&(num[i]!=num[i-1]+1)){
                count=1;

            }
        }
        return sum;
    }
}
