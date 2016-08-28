package leetcodeNew.Array;

/**
 * Created by doubling on 16/8/1.
 */
public class FindMinimuminRotatedSortedArray153 {
    public int findMin(int[] nums) {
        int len = nums.length;
        if(len==0)
        {
            return 0;
        }
        else if(len==1)
        {
            return nums[0];
        }else if(len == 2)
        {
            return min(nums[0],nums[1]);
        }
        int start = 0;
        int end = len-1;
        while(start<end-1)
        {
            if(nums[start]<nums[end])
            {
                return nums[start];
            }
            int mid = start+(end-start)/2;
            if(nums[mid]>nums[start])
            {
                start=mid;
            }
            else{
                end=mid;        	}
        }
        return min(nums[start],nums[end]);
    }
    public int min(int i , int j )
    {
        if(i<j)
        {
            return i;
        }
        else
        {
            return j;
        }
    }

}
