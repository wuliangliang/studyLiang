package leetcode.array;

import java.util.*;

/**
 * Created by baidu on 16/7/14.
 */
public class IntersectionofTwoArrays349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0;i<nums1.length;i++)
            set.add(nums1[i]); //遍历增加
        List<Integer> resultList = new ArrayList<Integer>();
        for (int i=0;i<nums2.length;i++)
            if(set.contains(nums2[i])){
                resultList.add(nums2[i]);
                set.remove(nums2[i]); //记得删除
            }
        int result[] = new int[resultList.size()];
        for(int i=0;i<resultList.size();i++)
            result[i]=resultList.get(i);
        return result;
    }
}
