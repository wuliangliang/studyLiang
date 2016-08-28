package leetcodeNew.BIT;

import java.util.*;

/**
 * Created by baidu on 16/8/4.
 */
public class SingleNumber136 {
    public int singleNumber(int[] nums) {
        int num = 0;
        for(int i=0;i<nums.length;i++){
            num^=nums[i];
        }
        return num;

    }
    public int singleNumber2(int[] nums) {
        //1、肯定是排序
        Arrays.sort(nums);
        //2、肯定是每三个数一组
        for(int i=0;i<nums.length-3;i+=3){
            //3、只需要比较每组的第一和第二个数是否相等
            if((nums[i]!=nums[i+1]))
                return nums[i];
        }
        return nums[nums.length-1];//每三个一组，最后的一个是single one
    }
    public static int[] singleNumber3(int[] nums) {
        int diff = 0;
        for(int num: nums){
            diff^=num;
        }
        diff = Integer.highestOneBit(diff);

        int[] result = new int[2];
        Arrays.fill(result,0);
        for(int num: nums){
            if((diff & num) == 0){
                result[0] ^= num;
            }
            else{
                result[1] ^= num;
            }
        }
        return result;
    }
    public static int[] singleNumber3_1(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> listss= new ArrayList<>();
        for(int num:nums){
            listss.add(num);
        }
        ArrayList<Integer> list = new ArrayList();
       for(int i = 0 ; i<nums.length-1;i++){
           if(nums[i]==nums[i+1]){
               list.add(nums[i]);
               list.add(nums[i+1]);
               i++;
           }

       }
        listss.removeAll(list);
        int[] res = new int[2];
        for(int i =0;i<listss.size();i++)
            res[i]=listss.get(i);
        return res;
    }


    public static void main(String[] args) {
        int [] nums= new int[]{2,2,4,4,5,5,4,4,7,7,8,9};
        System.out.println(singleNumber3_1(nums).toString());
    }
}
