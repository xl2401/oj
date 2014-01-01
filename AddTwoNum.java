public class AddTwoNum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        boolean carry = false;
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        while (ptr1 != null || ptr2 != null || carry){
            int sum = 0;
            if (ptr1 != null){
                sum += ptr1.val;
            }
            if (ptr2 != null){
                sum += ptr2.val;
            }
            if (carry) sum++;
            if (sum >= 10){
                carry = true;
                sum -= 10;
            }
            else{
                carry = false;
            }
            ListNode current = new ListNode(sum);
            prev.next = current;
            prev = current;
            if (ptr1 != null){
                ptr1 = ptr1.next;
            }
            if (ptr2 != null){
                ptr2 = ptr2.next;
            }
        }
        return dummy.next;
    }
}
