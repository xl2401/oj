/*
 * Title: Add Two Numbers
 * Description:
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 * Solution:
 * add node by node, easy
 */
public class AddTwoNum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        int carry = 0;
        while (l1 != null || l2 != null){
            int sum = 0;
            if (l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            if (sum >= 10){
                sum -= 10;
                carry = 1;
            }
            else{
                carry = 0;
            }
            ListNode newNode = new ListNode(sum);
            prev.next = newNode;
            prev = newNode;
        }
        if (carry == 1){
            ListNode newNode = new ListNode(1);
            prev.next = newNode;
        }
        return dummy.next;
    }
}
