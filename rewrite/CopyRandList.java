/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode ptr = head;
        // put new node right after the original node
        while (ptr != null) {
            RandomListNode ptrNext = ptr.next;
            RandomListNode newNode = new RandomListNode(ptr.label);
            ptr.next = newNode;
            newNode.next = ptrNext;
            ptr = ptrNext;
        }
        // copy random attribute
        ptr = head;
        while (ptr != null) {
            RandomListNode random = ptr.random;
            if (random != null) ptr.next.random = random.next;
            ptr = ptr.next.next;
        }
        // reconstruct list and recover
        RandomListNode dum = new RandomListNode(0);
        RandomListNode prev = dum;
        ptr = head;
        while (ptr != null) {
            RandomListNode cur = ptr.next;
            prev.next = cur;
            prev = cur;
            ptr.next = ptr.next.next;
            ptr = ptr.next;
        }
        return dum.next;
    }
}