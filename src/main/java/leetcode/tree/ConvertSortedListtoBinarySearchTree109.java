package leetcode.tree;


/**
 * Created by doubling on 16/8/6.
 */
public class ConvertSortedListtoBinarySearchTree109 {

    /*
    109. Convert Sorted List to Binary Search Tree  QuestionEditorial Solution  My Submissions
    Total Accepted: 77611
    Total Submissions: 246978
    Difficulty: Medium
    Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

    Subscribe to see which companies asked this question

    Show Tags
    Show Similar Problems
    */
    static ListNode currentHead = null;
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) {
            return null;
        }
        currentHead = head;
        int len = 0;
        while(head!=null) {
            len++;
            head = head.next;
        }

        return buildTree(0, len-1);
    }
    TreeNode buildTree(int start, int end) {
        if(start>end) {
            return null;
        }
        int mid = start + (end - start)/2;
        TreeNode left = buildTree(start, mid-1);
        TreeNode root = new TreeNode(currentHead.val);
        root.left = left;
        currentHead = currentHead.next;
        root.right = buildTree(mid + 1, end);
        return root;
    }
}
class Solution {
    ListNode getLeftNodeFromList(ListNode head) {
        ListNode next = head;
        ListNode current = head;
        ListNode pre = head;

//
//        while(next.next!=null) {
//            next = next.next.next;
//            pre=pre.next;
//        }
//


        while(next!=null) {
            next = next.next;
            if(next==null) {
                break;
            }
            next = next.next;
            if(next==null) {
                break;
            }
            pre = head;
            head = head.next;
        }
        return pre;
    }


    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) {
            return null;
        }
        if(head.next==null) {
            return new TreeNode(head.val);
        }

        ListNode left = getLeftNodeFromList(head);
        ListNode mid = left.next;
        TreeNode root = new TreeNode(mid.val);
        left.next     = null;
        root.left     = sortedListToBST(head);
        root.right    = sortedListToBST(mid.next);
        return root;
    }

}