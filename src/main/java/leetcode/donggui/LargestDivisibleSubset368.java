package leetcode.donggui;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by baidu on 16/7/25.
 */

/*
每次循环都是从尾到头除一下， 找到最长的数字
 */
public class LargestDivisibleSubset368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int size = nums.length;
        Arrays.sort(nums);
        int[] countOfRecord = new int[size];
        int maxCount = 0;
        int index = -1;
        for(int i = 0;i<size;i++){
            int cur = nums[i];
            boolean finished = false;
            int max = 0;
            for(int j = i-1;j>=0;j--){
                if(cur % nums[j] == 0){//整除
                    finished = true;
                    max = Math.max(countOfRecord[j]+1,max);
                }
            }
            countOfRecord[i] = max;

            if(!finished)
                countOfRecord[i] = 1;
            if(countOfRecord[i] > maxCount){
                maxCount = countOfRecord[i];
                index = i;
            }
        }
        int count = 0;
        List<Integer> res = new LinkedList<>();
        for(int i = index;i>=0 && count < maxCount;i--){
            if(nums[index] % nums[i] == 0){
                res.add(nums[i]);
                count++;
            }
        }
        return res;
    }
}
