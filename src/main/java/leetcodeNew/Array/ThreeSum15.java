package leetcodeNew.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by doubling on 16/7/31.
 */
public class ThreeSum15 {
    List<List<Integer>> ret  = new ArrayList<List<Integer>>();
    public List<List<Integer>> threeSum(int[] nums)
    {
        if(nums.length<=2)
        {
            return ret;
        }
        Arrays.sort(nums);
        int len  = nums.length;
        for(int i = 0;i<len-2;i++)
        {
            if(i>0&&nums[i]==nums[i-1])
            {
                continue;
            }
            find(nums, i+1,len-1,nums[i]);
        }
        return ret;
    }
    public void find(int[] nums,int start,int end ,int target)
    {
        int i = start , j = end;
        while(i<j)
        {
            if(nums[i]+nums[j]+target==0)
            {
                List<Integer> li = new ArrayList<Integer>();
                li.add(target);
                li.add(nums[i]);
                li.add(nums[j]);
                ret.add(li);
                while(i<j&&nums[i]==nums[i+1]) i++;
                while(i<j&&nums[j]==nums[j-1]) j--;
                i++;
                j--;
            }
            else if(nums[i]+nums[j]+target<0)
            {
                i++;
            }
            else
                j--;
        }
    }}
