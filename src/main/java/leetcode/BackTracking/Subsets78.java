package leetcode.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by baidu on 16/8/26.
 */
public class Subsets78 {
    /*
    78. Subsets  QuestionEditorial Solution  My Submissions
    Total Accepted: 111119
    Total Submissions: 330351
    Difficulty: Medium
    Given a set of distinct integers, nums, return all possible subsets.

    Note: The solution set must not contain duplicate subsets.

    For example,
    If nums = [1,2,3], a solution is:

    [
      [3],
      [1],
      [2],
      [1,2,3],
      [1,3],
      [2,3],
      [1,2],
      []
    ]
    Subscribe to see which companies asked this question

    Hide Tags Array Backtracking Bit Manipulation
    Show Similar Problems
     */
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list=new ArrayList<Integer>();
        backtracking(list,nums,0);
        return result;
    }
    public void backtracking(List<Integer> list,int[] nums,int start){
        result.add(new ArrayList<>(list));
        for(int i = start ; i <nums.length;i++){
            list.add(nums[i]);
            backtracking(list,nums,i+1);
            list.remove(list.size()-1);
        }
    }


    /*
    90. Subsets II  QuestionEditorial Solution  My Submissions
    Total Accepted: 77540
    Total Submissions: 242133
    Difficulty: Medium
    Given a collection of integers that might contain duplicates, nums, return all possible subsets.

    Note: The solution set must not contain duplicate subsets.

    For example,
    If nums = [1,2,2], a solution is:

    [
      [2],
      [1],
      [1,2,2],
      [2,2],
      [1,2],
      []
    ]
     Subscribe to see which companies asked this question
     */
    List<List<Integer>> result1 = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums);
        backtracking1(list,nums,0);
        return result1;
    }
    public void backtracking1(List<Integer> list,int[] nums,int start){
        result1.add(new ArrayList<>(list));
        for(int i = start ; i <nums.length;i++){
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            list.add(nums[i]);
            backtracking1(list,nums,i+1);
            list.remove(list.size()-1);
        }

    }
}
