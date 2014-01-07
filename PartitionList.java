import java.util.ArrayList;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        else{
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode i = dummy;
            ListNode j = head;
            // find end of list;
            ListNode last = dummy;
            while (last.next != null){
                last = last.next;
            }
            ListNode endFlag = null;

            // put node ge x to the end of the list
            while (j != endFlag){
                if (j.next == null) {
                    last = j;
                    break;
                }
                if (j.val >= x){
                    // end flag is the first element after original end
                    if (endFlag == null) endFlag = j;
                    i.next = j.next;
                    last.next = j;
                    last = j;
                    j = i.next;
                }
                else{
                    i = i.next;
                    j = j.next;
                }
            }
            last.next = null;
            return dummy.next;
        }
    }

    public static void main(String[] args){
        ListNode a = new ListNode(2);
        //ListNode b = new ListNode(1);
        //a.next = b;
        ListNode head = new PartitionList().partition(a, 1);
        System.out.println(head.val);
    }
}
