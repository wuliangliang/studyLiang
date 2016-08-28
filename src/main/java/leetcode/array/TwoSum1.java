package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by baidu on 16/8/12.
 */
public class TwoSum1 {
    /*
    1. Two Sum  QuestionEditorial Solution  My Submissions
    Total Accepted: 271762
    Total Submissions: 1067832
    Difficulty: Easy
    Given an array of integers, return indices of the two numbers such that they add up to a specific target.

    You may assume that each input would have exactly one solution.

            Example:
    Given nums = [2, 7, 11, 15], target = 9,

    Because nums[0] + nums[1] = 2 + 7 = 9,
            return [0, 1].
    UPDATE (2016/2/13):
    The return format had been changed to zero-based indices. Please read the above updated description carefully.

    Subscribe to see which companies asked this question

    Show Tags
    Show Similar Problems
    */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        ArrayList list = (ArrayList) Arrays.asList(nums);
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0 ; i< nums.length;i++){
            if(map.containsKey(nums[i])){
                res[0] = map.get(nums[i]);
                res[1]=i;
                break;
            }else{
                map.put(target-nums[i],i);
            }
        }
        return res;
    }

}
