package leetcode.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baidu on 16/9/1.
 */
public class PathSumII113 {
    /*
    113. Path Sum II  QuestionEditorial Solution  My Submissions
    Total Accepted: 93365
    Total Submissions: 313874
    Difficulty: Medium
    Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

    For example:
    Given the below binary tree and sum = 22,
                  5
                 / \
                4   8
               /   / \
              11  13  4
             /  \    / \
            7    2  5   1
    return
    [
       [5,4,11,2],
       [5,8,4,5]
    ]
    Subscribe to see which companies asked this question
     */
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    ArrayList<Integer> path = new ArrayList<Integer>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        getSum(root, 0, sum);
        return result;
    }
    public void getSum(TreeNode root, int sum, int target){
        if(root == null) {
            return;
        }
        sum+= root.val;
        path.add(root.val);
        if(root.left == null && root.right == null && sum== target)
            result.add(new ArrayList<>(path));
        getSum(root.left, sum, target);
        getSum(root.right, sum, target);
        sum-=root.val;
        path.remove(path.size()-1);
        return;
    }
}
