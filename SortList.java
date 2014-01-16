/*
 * Title: Sort List
 * Description:
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Solution:
 * Use 3 way quick sort
 * consider equal key of listnode value
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode end = head;
        while (end.next != null)
            end = end.next;
        partition(dummy, end);
        return dummy.next;
    }

    /*
     * Partition list from l.next -> h
     * l.next is the pivot
     * iterate over l.next.next to h
     * every node on the left of lt is smaller than pivot
     * every node on the right of gt is greater than pivot
     */
    public void partition(ListNode l, ListNode h){
        if (l == h || l.next == h)
            return;
        // partition l.next -> h
        ListNode lt = l.next;
        int pivot = lt.val;
        ListNode ptr = lt;
        ListNode gt = h;

        ListNode leftIns = l;
        ListNode rightIns = h;

        while (ptr != gt){
            if (ptr.next != null){
                ListNode cur = ptr.next;
                if (cur.val < pivot){// move cur to left of lt
                    // special occasion: if move gt to left, update gt
                    if (ptr.next == gt){
                        if (rightIns == gt)
                            rightIns = ptr;
                        gt = ptr;
                    }
                    ptr.next = cur.next;
                    cur.next = leftIns.next;
                    leftIns.next = cur;
                    leftIns = cur;
                }
                else if (cur.val > pivot){
                    // special occassion: avoid move itself to its right
                    if (ptr.next == gt && gt == rightIns)
                        break;
                    // special occasion: if move gt to right, update gt
                    if (ptr.next == gt){
                        gt = ptr;
                    }
                    ptr.next = cur.next;
                    cur.next = rightIns.next;
                    rightIns.next = cur;
                    rightIns = cur;
                }
                else{
                    ptr = ptr.next;
                }
            }
            else
                break;
        }
        partition(l, leftIns);
        partition(gt, rightIns);
    }

    public static void main(String[] args){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(5);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        SortList sl = new SortList();
        ListNode head = sl.sortList(a);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
