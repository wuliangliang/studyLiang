package leetcode.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baidu on 16/8/26.
 */
public class Permutations46 {
    /*
    46. Permutations  QuestionEditorial Solution  My Submissions
    Total Accepted: 115337
    Total Submissions: 305181
    Difficulty: Medium
    Given a collection of distinct numbers, return all possible permutations.

    For example,
    [1,2,3] have the following permutations:
    [
      [1,2,3],
      [1,3,2],
      [2,1,3],
      [2,3,1],
      [3,1,2],
      [3,2,1]
    ]
    Subscribe to see which companies asked this question

    Show Tags
    Show Similar Problems
     */

    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        List list = new ArrayList<>();
        backtrack(list, nums);
        return result;
    }

    private void backtrack(List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (list.contains(nums[i])) continue; // element already exists, skip
                list.add(nums[i]);
                backtrack(list, nums);
                list.remove(list.size() - 1);
            }
        }
    }


}
