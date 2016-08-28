package leetcode.array;

import java.util.Stack;

/**
 * Created by baidu on 16/8/24.
 */
/*

题目的地址是:https://leetcode.com/problems/largest-rectangle-in-histogram/

84. Largest Rectangle in Histogram  QuestionEditorial Solution  My Submissions
Total Accepted: 67628
Total Submissions: 271036
Difficulty: Hard
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given heights = [2,1,5,6,2,3],
return 10.

Subscribe to see which companies asked this question
 */
public class LargestRectangleinHistogram84 {
    public int largestRectangleArea(int[] heights) {
        int[] nHeihgts = new int[heights.length+1];
        for(int i =0 ; i< heights.length;i++)
            nHeihgts[i]=heights[i];
        nHeihgts[heights.length]=0;
        Stack<Integer> stack = new Stack<>();
        int i =0 ;
        int maxArea = 0;
        while(i<nHeihgts.length)
        {
            if(stack.isEmpty()||nHeihgts[stack.peek()]<=nHeihgts[i])
            {
                stack.push(i++);
            }
            else
            {
                int t = stack.peek();
                stack.pop();
                maxArea = Math.max(maxArea, nHeihgts[t]*(stack.isEmpty()?i:i-stack.peek()-1));
            }
        }
        return maxArea;
    }

    /*
    这道题可以有两个解法。

    解法一是穷举法，对于直方图的每一个右边界，穷举所有的左边界。将面积最大的那个值记录下来。
    时间复杂度为O(n^2).
    单纯的穷举在LeetCode上面过大集合时会超时。
    可以通过选择合适的右边界，做一个剪枝(Pruning)。
    观察发现当height[k] >= height[k - 1]时，无论左边界是什么值，选择height[k]总会比选择height[k - 1]所形成的面积大。
    因此，在选择右边界的时候，首先找到一个height[k] < height[k - 1]的k,然后取k - 1作为右边界，穷举所有左边界，找最大面积.
     */

    // O(n^2) with pruning
    public int largestRectangleArea1(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int area = 0;
        for (int i = 0; i < height.length; i++) {
            for (int k = i + 1; k < height.length; k++) {
                if (height[k] < height[k - 1]) {
                    i = k - 1;
                    break;
                } else {
                    i = k;
                }
            }
            int lowest = height[i];
            for (int j = i; j >= 0; j--) {
                if (height[j] < lowest) {
                    lowest = height[j];
                }
                int currArea = (i - j + 1) * lowest;
                if (currArea > area) {
                    area = currArea;
                }
            }
        }
        return area;
    }
}
