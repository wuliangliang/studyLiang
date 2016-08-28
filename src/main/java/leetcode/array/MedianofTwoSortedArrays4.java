package leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by baidu on 16/8/12.
 */
public class MedianofTwoSortedArrays4 {
    /*
    4. Median of Two Sorted Arrays  QuestionEditorial Solution  My Submissions
    Total Accepted: 107285
    Total Submissions: 549703
    Difficulty: Hard
    There are two sorted arrays nums1 and nums2 of size m and n respectively.

    Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

    Example 1:
    nums1 = [1, 3]
    nums2 = [2]

    The median is 2.0
    Example 2:
    nums1 = [1, 2]
    nums2 = [3, 4]

    The median is (2 + 3)/2 = 2.5
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list1=new ArrayList();
        for(int i : nums1){
            list1.add(i);
        }
        for(int i : nums2){
            list1.add(i);
        }
        double res=0;
        if(list1.size()==1){
            return list1.get(0);
        }

        Collections.sort(list1);
        if((list1.size()%2)!=0){
            res= ((double)list1.get(list1.size()/2));
        }else{
            res = (list1.get(list1.size()/2)+list1.get(list1.size()/2-1))*1.0/2.0;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] i={1,3};
        int[] z={2};
        System.out.println(3.0/2);
        System.out.println(findMedianSortedArrays(i,z));
    }
}
