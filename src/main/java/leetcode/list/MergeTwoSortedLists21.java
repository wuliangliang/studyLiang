package leetcode.list;

/**
 * Created by baidu on 16/8/11.
 */
public class MergeTwoSortedLists21 {
    /*
    21. Merge Two Sorted Lists  QuestionEditorial Solution  My Submissions
    Total Accepted: 145090
    Total Submissions: 397611
    Difficulty: Easy
    Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

    Subscribe to see which companies asked this question

    Show Tags
    Show Similar Problems

     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p,q,r,head;
        if(l1 == null && l2 == null){
            return null;
        }
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        p = l1;
        q = l2;
        head = null;
        if(p.val<=q.val){
            head=p;
            p=p.next;
        }else{
            head=q;
            q = q.next;
        }
        r = head;
        while(p !=null&&q!=null){
            if(p.val<=q.val){
                r.next = p;
                r = p;
                p = p.next;
            }else{
                r.next = q;
                r = q;
                q = q.next;
            }
        }
        if(p == null){
            while(q != null){
                r.next = q;
                r = q;
                q = q.next;
            }
        }
        else{
            while(p != null){
                r.next = p;
                r = p;
                p = p.next;
            }
        }
        return head;
    }
}
