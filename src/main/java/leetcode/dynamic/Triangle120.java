package leetcode.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by doubling on 16/8/6.
 */
public class Triangle120{
    /*
    120. Triangle  QuestionEditorial Solution  My Submissions
    Total Accepted: 77092
    Total Submissions: 247767
    Difficulty: Medium
    Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

    For example, given the following triangle
    [
         [2],
        [3,4],
       [6,5,7],
      [4,1,8,3]
    ]
    The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

    Note:
    Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

    Subscribe to see which companies asked this question
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        if(len<=0)
        {
            return -1;
        }
        if(len == 1)
            return triangle.get(0).get(0);
        List<Integer> ret = new ArrayList<Integer>(len);
        for(int i = 0 ;i<len;i++)
        {
            ret.add(i,triangle.get(len-1).get(i));
        }
        for(int i =len-2 ; i>= 0; i--)
        {
            for(int j= 0 ; j<=i;j++  )
            {
                ret.set(j, triangle.get(i).get(j)+Math.min(ret.get(j),ret.get(j+1)));
            }
        }
        return ret.get(0);
    }
}
