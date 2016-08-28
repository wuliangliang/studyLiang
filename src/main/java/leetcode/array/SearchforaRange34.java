package leetcode.array;

import org.junit.Test;

/**
 * Created by baidu on 16/8/26.
 */
public class SearchforaRange34 {
    /*
        34. Search for a Range  QuestionEditorial Solution  My Submissions
        Total Accepted: 96168
        Total Submissions: 320491
        Difficulty: Medium
        Given a sorted array of integers, find the starting and ending position of a given target value.

        Your algorithm's runtime complexity must be in the order of O(log n).

        If the target is not found in the array, return [-1, -1].

        For example,
        Given [5, 7, 7, 8, 8, 10] and target value 8,
        return [3, 4].

        Subscribe to see which companies asked this question

        Hide Tags
     */
    @Test
    public void test(){
        int nums[]= {2,2};
        int targt =2;
        System.out.println(searchRange(nums,targt)[0]);
    }


    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int count = 0 ;
        for(int i =0  ; i < nums.length;i++){
            if(nums[i] ==target){
                if(count ==0){
                    res[0]=i;
                }

                count++;

            }

        }
        if(count == 0){
            res[0]=-1;
            res[1]=-1;
        }
        else
        {
            res[1] = res[0]+count-1;
        }
        return res;
    }
}
