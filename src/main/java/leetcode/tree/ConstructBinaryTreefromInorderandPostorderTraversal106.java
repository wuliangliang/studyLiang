package leetcode.tree;

/**
 * Created by baidu on 16/8/9.
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0){
            return null;
        }

        TreeNode node=createTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
        return node;
    }
    public TreeNode createTree(int[] inorder,int inbegin,int inend,int[] postorder,int postbegin,int postend){
        if(inbegin>inend){
            return null;
        }

        int  root=postorder[postend];
        int index=0;
        for(int i=inbegin;i<=inend;i++){
            if(root==inorder[i]){
                index=i;
                break;
            }
        }

        int len=index-inbegin;
        TreeNode left=createTree(inorder, inbegin, index-1, postorder, postbegin, postbegin+len-1);
        TreeNode right=createTree(inorder, index+1, inend, postorder, postbegin+len, postend-1);
        TreeNode node=new TreeNode(root);
        node.left=left;
        node.right=right;
        return node;
    }
}
