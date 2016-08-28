package leetcodeNew.Array;

import java.util.HashMap;

/**
 * Created by doubling on 16/7/31.
 */
public class TwoSum1 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i= 0 ;i<nums.length;i++)
        {

            if(map.containsKey(nums[i]))
            {
                int index= map.get(nums[i]);
                result[0] = index ;
                result[1] = i;
                break;

            }
            else
            {
                map.put(target-nums[i],i );
            }
        }
        return result;
    }
}
