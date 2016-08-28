package leetcodeNew.Stack;

import java.util.Stack;

/**
 * Created by baidu on 16/8/4.
 */
public class evaluatereversepolishnotation150 {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for(String ele : tokens){
            if(isOp(ele)){
                int right = Integer.valueOf(stack.pop());
                int left = Integer.valueOf(stack.pop());
                int res = cal(left,right,ele);
                stack.push(String .valueOf(res));
            }else{
                stack.push(ele);
            }
        }
        return Integer.valueOf(stack.pop());
    }
    public boolean  isOp(String str){
        if(str.equals("+")||str.equals("-")||str.equals("*")||str.equals("/")){
            return true;
        }
        else
            return false;
    }
    public int cal(int left ,int right,String op){
        if(op.equals("+")){
            return left+right;
        }else if(op.equals("-")){
            return left-right;
        }else if(op.equals("*")){
            return left*right;
        }else if(op.equals("/")){
            return left/right;
        }
        else{
            return 0;
        }
    }
}
