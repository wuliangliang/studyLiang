package leetcodeNew.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by doubling on 16/8/4.
 */
public class preorderTraversal144 {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root != null)                             //若二叉树不空
        {
            list.add(root.val);
            preorderTraversal(root.left);                    //按先根次序遍历当前结点的左子树，递归调用
            preorderTraversal(root.right);                   //按先根次序遍历当前结点的右子树，递归调用
        }
        return list;
    }
    ArrayList<Integer> list1= new ArrayList<>();
    public ArrayList<Integer> preorderTraversal1(TreeNode root) {
        System.out.print("先根次序遍历（非递归）：  ");
        Stack< TreeNode> stack = new Stack<>();   //创建一个空栈
        TreeNode p = root;
        while (p!=null || !stack.isEmpty())      //p非空或栈非空时
            if (p!=null)
            {
                list1.add(p.val); //访问结点
                stack.push(p);                   //p结点入栈
                p=p.left;                        //进入左子树
            }
            else                                 //p为空且栈非空时
            {
                p=stack.pop();                   //p指向出栈结点
                p=p.right;                       //进入右子树
            }
        return list1;
    }
}
