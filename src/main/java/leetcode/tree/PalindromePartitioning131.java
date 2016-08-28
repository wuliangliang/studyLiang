package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by doubling on 16/7/22.
 */
public class PalindromePartitioning131 {
    public List<List<String>> partition(String s) {
        List<List<String>> al= new ArrayList<List<String>>();
        if(s.length()==0)
            return al;
        Stack<String> path=new Stack<String>();
        partition(s,0,"", (ArrayList<List<String>>) al,path);
        return al;
    }

    public void partition(String s,int start,String part_Str,ArrayList<List<String>> al,Stack<String> path){
        if(!part_Str.isEmpty()) {
            path.push(part_Str);
        }
        if(start==s.length()){
             ArrayList<String> re=new ArrayList<String>();
             for(String t:path)
                 re.add(t);
             al.add(re);
             return ;
        }
        for(int i = start;i<s.length();i++){
            if(isPar(s,start,i))
            {
                String par_Str=s.substring(start, i+1);
                partition(s,i+1,par_Str,al,path);
                path.pop();
            }
        }

    }


    public boolean isPar(String s,int start,int end) {
        if(s==""||s.length()==0||start>end||start<0||end>s.length()-1)
            return false;
        if(start==end)
            return true;
        int i=start;
        int j=end;
        while(i<=j)
        {
            if(s.charAt(i)!=s.charAt(j))
                return false;
            else
            {
                i++;
                j--;
            }
        }
        return true;
    }

}