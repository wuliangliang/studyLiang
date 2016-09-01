package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baidu on 16/7/27.
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
