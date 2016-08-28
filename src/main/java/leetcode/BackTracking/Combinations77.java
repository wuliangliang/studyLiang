package leetcode.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baidu on 16/8/26.
 */
public class Combinations77 {
    /*
    77. Combinations  QuestionEditorial Solution  My Submissions
    Total Accepted: 86980
    Total Submissions: 240131
    Difficulty: Medium
    Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

            For example,
    If n = 4 and k = 2, a solution is:

            [
            [2,4],
            [3,4],
            [2,3],
            [1,2],
            [1,3],
            [1,4],
            ]
    Subscribe to see which companies asked this question

    Show Tags
    Show Similar Problems
    */
    List<List<Integer>> result=new ArrayList<List<Integer>>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list=new ArrayList<Integer>();
        backtracking(n,k,1,list);
        return result;

    }
    public void backtracking(int n,int k,int start ,List<Integer> list){
        if(k<0){
            return ;
        }else if(k==0){
            result.add(new ArrayList<Integer>(list));
        }else{
            for(int i =  start;  i<=n  ; i++){
                list.add(i);//尝试性的加入i
                backtracking(n,k-1,i+1,list);
                list.remove(list.size()-1);
            }
        }
    }

}
