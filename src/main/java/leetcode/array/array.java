package leetcode.array;

/**
 * Created by baidu on 16/7/12.
 */
public class array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int newIndex=m+n-1;
        int nums1s=m-1,nums2s=n-1;
        while(nums1s>=0 && nums2s>=0){
            if(nums1[nums1s]>=nums2[nums2s]){
                nums1[newIndex]=nums1[nums1s];
                newIndex--;
                nums1s--;
            }else{
                nums1[newIndex]=nums2[nums2s];
                newIndex--;
                nums2s--;
            }
        }
        while(nums1s>=0){
            nums1[newIndex]=nums1[nums1s];
            newIndex--;
            nums1s--;
        }
        while(nums2s>=0){
            nums1[newIndex]=nums2[nums2s];
            newIndex--;
            nums2s--;
        }
    }
}
