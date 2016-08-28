package leetcode.array;

import org.junit.Test;

/**
 * Created by baidu on 16/8/26.
 */
public class SearchInsertPosition35 {
    /*
        35. Search Insert Position  QuestionEditorial Solution  My Submissions
        Total Accepted: 119225
        Total Submissions: 312525
        Difficulty: Medium
        Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

        You may assume no duplicates in the array.

        Here are few examples.
        [1,3,5,6], 5 → 2
        [1,3,5,6], 2 → 1
        [1,3,5,6], 7 → 4
        [1,3,5,6], 0 → 0

        Subscribe to see which companies asked this question
     */
    @Test
    public void test(){
        int[] nums={1,3};
        int target = 0 ;
        System.out.println(searchInsert(nums,target));
    }
    public int searchInsert(int[] nums, int target) {
        int res = 0 ;
        for(int i = 0 ; i < nums.length ; i ++){
            if (i ==( nums.length - 1) && nums[i] < target) {
                res = nums.length;
            }
            else if(nums[i]==target){
                res= i;
                break;
            }else if(nums[i]>target){
                res= i;
                break;
            }
        }
        return res;
    }
}
