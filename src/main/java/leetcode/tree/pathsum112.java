package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baidu on 16/7/27.
 */
    /*
    112. Path Sum  QuestionEditorial Solution  My Submissions
    Total Accepted: 119150
    Total Submissions: 371270
    Difficulty: Easy
    Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

    For example:
    Given the below binary tree and sum = 22,
                  5
                 / \
                4   8
               /   / \
              11  13  4
             /  \      \
            7    2      1
    return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

    Subscribe to see which companies asked this question

    Show Tags
    Show Similar Problems

     */
public class pathsum112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        int diff = sum-root.val;
        boolean left = false;
        boolean right = false;
        if(null==root.left&&null==root.right&&diff==0) //递归结束条件
            return true;
        else{
            if(null!=root.left)
                left=hasPathSum(root.left,diff);
            if(null!=root.right)
                right=hasPathSum(root.right,diff);
            return left||right;
        }
    }



    List<List<Integer>> result = new ArrayList<List<Integer>>();
    ArrayList<Integer> path = new ArrayList<Integer>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        getSum(root, 0, sum);
        return result;
    }
    public void getSum(TreeNode root, int sum, int target){
        if(root == null) return;
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
