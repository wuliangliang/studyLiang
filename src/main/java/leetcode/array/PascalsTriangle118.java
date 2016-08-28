package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by doubling on 16/8/6.
 */
public class PascalsTriangle118 {
    /*
    119. Pascal's Triangle II
    Given numRows, generate the first numRows of Pascal's triangle.
    For example, given numRows = 5,
    Return

    [
         [1],
        [1,1],
       [1,2,1],
      [1,3,3,1],
     [1,4,6,4,1]
    ]
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for(int i = 0 ;i<numRows;i++ )
        {
            if(i == 0)
            {
                List<Integer> li = new ArrayList<Integer>();
                li.add(1);
                ret.add(li);
            }
            else if(i == 1)
            {
                List<Integer> li = new ArrayList<Integer>();
                li.add(1);
                li.add(1);
                ret.add(li);
            }
            else
            {
                List<Integer> li = new ArrayList<Integer>();
                li.add(1);
                for(int j = 1;j<i;j++)
                {
                    li.add(ret.get(i-1).get(j-1)+ ret.get(i-1).get(j));
                }
                li.add(1);
                ret.add(li);
            }
        }
        return ret;
    }
    /*

    119. Pascal's Triangle II  QuestionEditorial Solution  My Submissions
    Total Accepted: 84091
    Total Submissions: 251435
    Difficulty: Easy
    Given an index k, return the kth row of the Pascal's triangle.

    For example, given k = 3,
    Return [1,3,3,1].

    Note:
    Could you optimize your algorithm to use only O(k) extra space?

    Subscribe to see which companies asked this question

    Show Tags
    Show Similar Problems

     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> li = new ArrayList<Integer>();
        for(int i = 0 ;i<rowIndex+1;i++)
        {
            if(i == 0)
            {

                li.add(1);
            }
            else if(i == 1)
            {
                li.clear();
                li.add(1);
                li.add(1);

            }
            else
            {
                li.add(1);
                for(int j = i-1;j>0;j--)
                {
                    li.set(j,li.get(j)+li.get(j-1));
                }

            }
        }
        return li;
    }
}
