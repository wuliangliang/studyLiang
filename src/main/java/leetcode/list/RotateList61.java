package leetcode.list;

/**
 * Created by baidu on 16/8/11.
 */
public class RotateList61 {
    /*
    61. Rotate List  QuestionEditorial Solution  My Submissions
    Total Accepted: 77471
    Total Submissions: 330908
    Difficulty: Medium
    Given a list, rotate the list to the right by k places, where k is non-negative.

    For example:
    Given 1->2->3->4->5->NULL and k = 2,
    return 4->5->1->2->3->NULL.

    Subscribe to see which companies asked this question

    Show Tags
    Show Similar Problems

     */
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0||head==null)
        {
            return head;
        }
        ListNode ret = head;
        ListNode p = head;
        ListNode pf = head;
        int count =1;
        while(p.next!=null)
        {
            count++;
            p=p.next;
        }
        k=k%count;
        if(k>0)
        {
            for(int i = 1;i<count-k;i++)
            {
                pf = pf.next;
            }
            ret = pf.next;
            p.next=head;
            pf.next=null;
        }
        return ret;
    }
}
