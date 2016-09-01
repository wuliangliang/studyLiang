package leetcode.dynamic;

/**
 * Created by baidu on 16/9/1.
 */
public class MaximumSubarray53 {
    /*
    53. Maximum Subarray  QuestionEditorial Solution  My Submissions
    Total Accepted: 130543
    Total Submissions: 347607
    Difficulty: Medium
    Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

    For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
    the contiguous subarray [4,-1,2,1] has the largest sum = 6.

    click to show more practice.
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];

        int[] sum = new int[nums.length];
        sum[0]=nums[0];
        for(int i = 1 ; i < nums.length;i++){
            sum[i] = Math.max(nums[i], sum[i - 1] + nums[i]);
            max = Math.max(max, sum[i]);
        }
        return max;

    }


}
