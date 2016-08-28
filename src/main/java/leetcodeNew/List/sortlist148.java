package leetcodeNew.List;


/**
 * Created by baidu on 16/8/4.
 */
public class sortlist148 {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode mid = getMid(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        return mergeSort(left, right);
    }
    private ListNode getMid(ListNode head){
        ListNode temp = head.next;
        ListNode mid = head;
        while(temp!=null&&temp.next!=null){
            mid = mid.next;
            temp = temp.next.next;
        }
        return mid;
    }
    private ListNode mergeSort(ListNode left,ListNode right){
        if(left==null)
            return right;
        if(right==null)
            return left;
        ListNode head = null;
        if(left.val>right.val){
            head = right;
            right = right.next;
        }else{
            head = left;
            left = left.next;
        }
        ListNode temp = head;
        while(right!=null&&left!=null){
            if(left.val>right.val){
                temp.next = right;
                right = right.next;
            }else{
                temp.next = left;
                left = left.next;
            }
            temp = temp.next;
        }
        if(right!=null){
            temp.next = right;
        }
        if(left!=null){
            temp.next = left;
        }
        return head;
    }
}
