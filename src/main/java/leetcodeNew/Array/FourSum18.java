package leetcodeNew.Array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by doubling on 16/7/31.
 */
public class FourSum18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = 	new ArrayList<List<Integer>>();
        if(nums.length<=2)
        {
            return ret;
        }
        int len = nums.length;
        Arrays.sort(nums);
        for(int i = 0 ; i< len-3;++i)
        {
            if(i>0&&nums[i]==nums[i-1])
            {
                continue;
            }
            for(int j = i+1 ; j<len-2;++j)
            {
                if(j>i+1&&nums[j]==nums[j-1])
                {
                    continue;
                }
                int x = j+1;
                int y = len-1;
                while(x<y)
                {
                    int sum =nums[x]+nums[y]+nums[i]+nums[j];
                    if(sum==target)
                    {
                        List<Integer> li = new ArrayList<Integer>();
                        li.add(nums[i]);
                        li.add(nums[j]);
                        li.add(nums[x]);
                        li.add(nums[y]);
                        ret.add(li);
                        do{++x;}
                        while(x<y&&nums[x]==nums[x-1]);
                        do{--y;}
                        while(x<y&&nums[y]==nums[y+1]);

                    }
                    else if(sum<target)
                    {
                        ++x;
                    }else
                    {
                        --y;
                    }
                }
            }
        }
        return ret;
    }}
