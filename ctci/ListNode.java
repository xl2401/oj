 public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }

     public static ListNode constuctList(int[] vals) {
         ListNode dummy = new ListNode(0);
         ListNode prev = dummy;
         for (int val : vals) {
             ListNode cur = new ListNode(val);
             prev.next = cur;
             prev = cur;
         }
         return dummy.next;
     }

     public static void printList(ListNode head) {
         while (head != null) {
             System.out.println(head.val);
             head = head.next;
         }
     }
 }
