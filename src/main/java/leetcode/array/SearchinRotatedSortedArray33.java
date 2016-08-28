package leetcode.array;

import java.util.ArrayList;

/**
 * Created by baidu on 16/8/23.
 */
public class SearchinRotatedSortedArray33 {

    /*
    33. Search in Rotated Sorted Array  QuestionEditorial Solution  My Submissions
    Total Accepted: 115684
    Total Submissions: 372943
    Difficulty: Hard
    Suppose a sorted array is rotated at some pivot unknown to you beforehand.

    (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

    You are given a target value to search. If found in the array return its index, otherwise return -1.

    You may assume no duplicate exists in the array.

            Subscribe to see which companies asked this question

    Hide Tags Binary Search Array
    Show Similar Problems
    */

    public int search(int[] nums, int target) {

        return binarySearch(nums,0,nums.length-1,target);
    }

    //分四种情况讨论。。。
    private int binarySearch(int[] nums,int left,int right,int target){
        if(left>right){
            return -1;
        }
        int mid = left+(right-left)/2;
        if(target==nums[mid]){
            return mid;
        }
        if(nums[left] <= nums[mid]){
            if(nums[left]<=target && target<nums[mid]){
                return binarySearch(nums,left, mid-1, target);
            }else{
                return  binarySearch(nums, mid+1, right, target);
            }
        }else {
            if(nums[mid]<target&& target<=nums[right]){
                return  binarySearch(nums,mid+1, right, target);
            }else{
                return  binarySearch(nums, left, mid-1, target);
            }
        }
    }

    /*
    81. Search in Rotated Sorted Array II  QuestionEditorial Solution  My Submissions
    Total Accepted: 70626
    Total Submissions: 217900
    Difficulty: Medium
    Follow up for "Search in Rotated Sorted Array":
    What if duplicates are allowed?

    Would this affect the run-time complexity? How and why?

    Write a function to determine if a given target is in the array.

    Subscribe to see which companies asked this question
     */

}
