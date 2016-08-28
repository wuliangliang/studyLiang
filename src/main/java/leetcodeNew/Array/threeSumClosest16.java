package leetcodeNew.Array;

import java.util.Arrays;

/**
 * Created by doubling on 16/7/31.
 */
public class threeSumClosest16 {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length<=2)
        {
            return -1;
        }
        Arrays.sort(nums);
        int ret =0 ;
        int closet = Integer.MAX_VALUE;
        int len = nums.length;
        for(int i =0 ; i< len-2;i++)
        {
            if(i>2&&nums[i]==nums[i-1])
            {
                continue;
            }
            int x = i+1;
            int y = len-1;
            while(x<y)
            {
                int sum = nums[x] + nums[y] + nums[i];
                if(sum< target)
                {
                    if(target-sum < closet)
                    {
                        closet = target-sum;
                        ret = sum;
                    }
                    x++;
                }
                else if(sum>target)
                {
                    if(sum - target < closet)
                    {
                        closet = sum-target;
                        ret = sum;
                    }
                    y--;
                }
                else
                    return sum;
            }

        }
        return ret;
    }
}
