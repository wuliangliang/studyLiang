package leetcode.string;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by baidu on 16/8/10.
 */
public class SimplifyPath71 {
    /*

    71. Simplify Path  QuestionEditorial Solution  My Submissions
    Total Accepted: 58402
    Total Submissions: 256432
    Difficulty: Medium
    Given an absolute path for a file (Unix-style), simplify it.

    For example,
    path = "/home/", => "/home"
    path = "/a/./b/../../c/", => "/c"
    click to show corner cases.

    Subscribe to see which companies asked this question

    Show Tags
     */
    @Test
    public void test(){

        simplifyPath("/");
    }
    public String simplifyPath(String path) {
       if(path==null||path.length()==0){
           return null;
       }
        Stack<String> stack = new Stack<>();
        String[] list = path.split("/");
        for(int i = 0 ; i < list.length; i ++){
            if(list[i].equals(".")||list[i].length()==0)
                continue;
            else if(!list[i].equals(".."))
                stack.push(list[i]);
            else{
                if(!stack.isEmpty())    //如果为 .. 则返回上一级,所以要弹出栈;
                    stack.pop();
                }
        }

        StringBuilder  sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop() );
            sb.insert(0, "/");
        }

        if(sb.length()==0) sb.insert(0, "/");
        return sb.toString();
    }



}
