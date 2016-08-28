package leetcodeNew.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by doubling on 16/8/4.
 */
public class BinaryTreePostorderTraversal145 {
    ArrayList list = new ArrayList();
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p=root, front=null;
        while (p!=null || !stack.isEmpty())                //p非空或栈非空时
            if (p!=null)
            {
                stack.push(p);                             //p结点入栈
                p=p.left;                                  //进入左子树
            }
            else                                           //p为空且栈非空时
            {
                p=stack.peek();                             //从左子树返回p结点，p结点不出栈
                if (p.right!=null && p.right!=front)       //p有右孩子，且右孩子没被访问过
                {
                    p = p.right;                           //进入右子树
                    stack.push(p);
                    p=p.left;                              //向左走
                }
                else
                {
                    p=stack.pop();
                    list.add(p.val);//从右子树返回p结点，p结点出栈
                    front = p;                             //front是p在后根遍历次序下的前驱结点
                    p=null;
                }
            }
        return list;
    }
}
