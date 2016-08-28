package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by baidu on 16/8/9.
 */
public class BinaryTreeLevelOrderTraversalII107 {
    /*
    107. Binary Tree Level Order Traversal II  QuestionEditorial Solution  My Submissions
    Total Accepted: 91098
    Total Submissions: 257206
    Difficulty: Easy
    Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

    For example:
    Given binary tree [3,9,20,null,null,15,7],
        3
       / \
      9  20
        /  \
       15   7
    return its bottom-up level order traversal as:
    [
      [15,7],
      [9,20],
      [3]
    ]
     */

    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            int num = queue.size();
            for(int i = 0 ; i < num;i++){
                TreeNode n = queue.poll();
                arrayList.add(n.val);
                if (n.left != null) {
                    queue.add(n.left);
                }
                if (n.right != null) {
                    queue.add(n.right);
                }
            }
            res.add(0,arrayList);

        }


        return res;
    }
}
