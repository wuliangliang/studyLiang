package leetcode.list;

/**
 * Created by baidu on 16/8/9.
 */
public class ReverseLinkedListII92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null)
            return null;
        int diff=n-m;
        ListNode headPre=new ListNode(0);
        headPre.next=head;
        ListNode slow=head;
        ListNode slowPre=headPre;
        for(int i=1;i<m;i++){
            slowPre=slow;
            slow=slow.next;
        }
        for(int j=0;j<diff;j++){
            ListNode temp=slow.next;
            slow.next=temp.next;
            temp.next=slowPre.next;
            slowPre.next=temp;
        }
        return headPre.next;
    }
}
