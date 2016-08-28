package leetcode.tree;

import java.util.Arrays;

/**
 * Created by baidu on 16/8/9.
 */
public class ConvertSortedArraytoBinarySearchTree108 {
    /*
    108. Convert Sorted Array to Binary Search Tree  QuestionEditorial Solution  My Submissions
    Total Accepted: 84474
    Total Submissions: 219002
    Difficulty: Medium
    Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

    Subscribe to see which companies asked this question

    Show Tags
    Show Similar Problems

    */
    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0){
            return null;
        }

        return createTree(nums , 0 , nums.length-1);


    }

    public static TreeNode createTree(int[] nums ,int start ,int end){
        TreeNode root=null;
        if(start>end) {
            return null ;
        }
        int mid = (end+start)/2;
        root = new TreeNode(nums[mid]);
        root.left = createTree(nums,start,mid-1);
        root.right = createTree(nums,mid+1,end);


        return root;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6};
        TreeNode t = sortedArrayToBST(nums);
        System.out.println(t);
    }

//方法2
    public TreeNode sortedArrayToBST2(int[] num) {
        if(num==null||num.length==0)
            return null;
        if(num.length==1)
            return new TreeNode(num[0]);
        int mid = num.length/2;
        TreeNode root = new TreeNode(num[mid]);
        TreeNode left = sortedArrayToBST(Arrays.copyOfRange(num, 0, mid));
        TreeNode right = sortedArrayToBST(Arrays.copyOfRange(num, mid+1, num.length));
        root.left = left;
        root.right = right;
        return root;
    }
}
