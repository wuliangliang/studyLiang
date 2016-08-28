package leetcode.list;

/**
 * Created by baidu on 16/8/12.
 */
public class AddTwoNumbers2 {
    /*
    2. Add Two Numbers  QuestionEditorial Solution  My Submissions
    Total Accepted: 166392
    Total Submissions: 680753
    Difficulty: Medium
    You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

            Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8

    Subscribe to see which companies asked this question

   */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode resT = res;
        int value = 0;
        int carry = 0;
        while (l1 != null && l2 != null) {
            value= l1.val+l2.val+carry;
            carry = value / 10;
            value = value % 10;
            resT.next = new ListNode(value);
            l1 = l1.next;
            l2 = l2.next;
            resT = resT.next;

        }
        ListNode p = (l1 == null) ? l2 : l1;
        while (p != null) {
            value = p.val + carry;
            carry = value / 10;
            value = value % 10;
            resT.next = new ListNode(value);
            p = p.next;
            resT = resT.next;
        }
        if (carry != 0) {
            resT.next = new ListNode(1);
        }

        return res.next;
    }
}
