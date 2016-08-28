package leetcode.collection;

/**
 * Created by baidu on 16/7/25.
 */
public class SingleNumber136 {
    public static void main(String[] args) {
        singleNumber(new int[]{2,2,3,3,2,2,1});
    }
    public static int singleNumber(int[] nums) {
        int num = 0;
        for(int i=0;i<nums.length;i++){
            num^=nums[i];
        }
        System.out.println(num);
        return num;
    }
    public int singleNumber2(int[] nums) {
        int[] bitnum=new int[32];
        for(int i = 0 ; i < 32 ;i++){
            bitnum[i]=0;
        }
        int res=0;
        for(int i=0; i<32; i++){
            for(int j=0; j<nums.length; j++){
                bitnum[i]+=(nums[j]>>i)&1;
            }
            res|=(bitnum[i]%3)<<i;
        }
        return res;
    }
}
