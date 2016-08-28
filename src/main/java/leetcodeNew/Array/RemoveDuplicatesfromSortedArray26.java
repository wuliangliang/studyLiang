package leetcodeNew.Array;

/**
 * Created by doubling on 16/8/1.
 */
public class RemoveDuplicatesfromSortedArray26 {
    public int removeDuplicates(int[] nums) {
        int j =0 ;
        for(int i =1;i<nums.length;i++)
        {
            if(nums[j]!=nums[i])
            {
                nums[++j]=nums[i];
            }
        }
        return j+1;
    }

    public int removeDuplicates2(int[] nums) {
        int j =0 ;
        int num =0 ;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[j]==nums[i])
            {
                num++;
                if(num<2)
                {
                    nums[++j]=nums[i];
                }
            }
            else
            {
                nums[++j]=nums[i];
                num=0;
            }
        }
        return j+1;
    }
}