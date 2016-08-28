package leetcodeNew.tree;

import java.util.ArrayList;

/**
 * Created by doubling on 16/8/6.
 */
public class uniquebinarysearchtrees96 {
    /*

    96. Unique Binary Search Trees  QuestionEditorial Solution  My Submissions
    Total Accepted: 91190
    Total Submissions: 237607
    Difficulty: Medium
    Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

    For example,
    Given n = 3, there are a total of 5 unique BST's.

       1         3     3      2      1
        \       /     /      / \      \
         3     2     1      1   3      2
        /     /       \                 \
       2     1         2                 3
    Subscribe to see which companies asked this question
     */
    public int numTrees(int n) {
        int[] cnt = new int[n+1];
        cnt[0] = 1;
        cnt[1] = 1;
        for(int i=2; i<=n; i++){
            for(int j=0; j<=i-1; j++){
                cnt[i] += cnt[j] * cnt[i-1-j];
            }
        }
        return cnt[n];
    }

    /*
    95. Unique Binary Search Trees II  QuestionEditorial Solution  My Submissions
    Total Accepted: 61131
    Total Submissions: 206992
    Difficulty: Medium
    Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

    For example,
    Given n = 3, your program should return all 5 unique BST's shown below.

       1         3     3      2      1
        \       /     /      / \      \
         3     2     1      1   3      2
        /     /       \                 \
       2     1         2                 3
    Subscribe to see which companies asked this question

    Show Tags
    Show Similar Problems

     */

    public ArrayList<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    private ArrayList<TreeNode> generate(int start, int end){
        ArrayList<TreeNode> rst = new ArrayList<TreeNode>();

        if(start > end){
            rst.add(null);
            return rst;
        }

        for(int i=start; i<=end; i++){
            ArrayList<TreeNode> left = generate(start, i-1);
            ArrayList<TreeNode> right = generate(i+1, end);
            for(TreeNode l: left){
                for(TreeNode r: right){
// should new a root here because it need to
// be different for each tree
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    rst.add(root);
                }
            }
        }
        return rst;
    }
}
