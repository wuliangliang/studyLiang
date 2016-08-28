package leetcode.tree;

import java.util.*;

/**
 * Created by baidu on 16/7/12.
 */
public class treeTest {
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root!=null){
            findPaths(root,String.valueOf(root.val));
        }
        return res;
    }
    public void findPaths(TreeNode node ,String path){
        if(node.left==null&&node.right==null){
            res.add(path);
        }
        if(node.left != null) findPaths(node.left, path+"->"+node.left.val);
        if(node.right != null) findPaths(node.right, path+"->"+node.right.val);
    }



    /*****************************************************/

}
