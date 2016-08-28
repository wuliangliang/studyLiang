package leetcode.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by baidu on 16/8/9.
 */
public class RemoveDuplicatesfromSortedList83 {
    /*
    83. Remove Duplicates from Sorted List  QuestionEditorial Solution  My Submissions
    Total Accepted: 131243
    Total Submissions: 348972
    Difficulty: Easy
    Given a sorted linked list, delete all duplicates such that each element appear only once.

    For example,
    Given 1->1->2, return 1->2.
    Given 1->1->2->3->3, return 1->2->3.

    Subscribe to see which companies asked this question
    */
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode headp = new ListNode(0);
        ListNode start = head;
        headp.next = head;
        ListNode p = headp;
        while(head!=null){
            if(set.contains(head.val)){
                p.next = head.next;
                head.next=null;
                head = p.next;
            }else {
                set.add(head.val);
                p = p.next;
                head = head.next;
            }

        }

        return start;
    }


    /*
    82. Remove Duplicates from Sorted List II  QuestionEditorial Solution  My Submissions
    Total Accepted: 80380
    Total Submissions: 290645
    Difficulty: Medium
    Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

    For example,
    Given 1->2->3->3->4->4->5, return 1->2->5.
    Given 1->1->1->2->3, return 2->3.

    Subscribe to see which companies asked this question
     */
    public ListNode deleteDuplicatesII(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode newHead = new ListNode(head.val-1);
        newHead.next = head;
        ListNode cur = head;
        ListNode last = newHead;
        while(cur!=null&&cur.next!=null){
            if(cur.val!=cur.next.val){
                last = cur;
            }else{
                while(cur.next!=null&&cur.val==cur.next.val) {
                    cur = cur.next;
                }
                last.next = cur.next;
            }
            cur = cur.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("nihao");
        list.add(null);
        list.add("nihao121");

        System.out.println(list);
    }
}
