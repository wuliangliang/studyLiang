package leetcode.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baidu on 16/8/26.
 */
public class Permutations47 {
    /*
    47. Permutations II  QuestionEditorial Solution  My Submissions
    Total Accepted: 83074
    Total Submissions: 282970
    Difficulty: Medium
    Given a collection of numbers that might contain duplicates, return all possible unique permutations.

    For example,
    [1,1,2] have the following unique permutations:
            [
            [1,1,2],
            [1,2,1],
            [2,1,1]
            ]
    Subscribe to see which companies asked this question
    */
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        List list = new ArrayList<>();
        boolean[] flag = new boolean[nums.length];
        backtrack(list, nums,flag);
        return result;
    }

    private void backtrack(List<Integer> list, int[] nums,boolean[] flag) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < nums.length; i++) {

                if(flag[i] || i > 0 && nums[i] == nums[i-1] && !flag[i - 1]) continue;
                flag[i] = true;
                list.add(nums[i]);
                backtrack(list, nums,flag);
                flag[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
