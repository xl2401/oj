import java.util.HashMap;

/*
 * Title:
 * Copy List with Random Pointer
 * Description:
 * A linked list is given such that each node contains 
 * an additional random pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 *
 * Solution1:
 * copy a linked list is easy, the problem is how to deal with the random
 * first copy without random and form a oldnode -> newnode map
 * and iterate the oldnode to add random relationship
 * don't forget the null-> null entry in the map
 * Solution2:
 * without extra space,
 * copy the node and insert after the original node in place,
 * generate random pointer
 * reconstruct the new list and recover original list
 */
public class CopyList {
    private HashMap<RandomListNode, RandomListNode> nodeMap = null;

    public RandomListNode copyRandomList1(RandomListNode head) {
        nodeMap = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode newHead = copyRandomListHelper(head);
        nodeMap.put(null, null);
        // add random
        while (head != null){
            RandomListNode cur = nodeMap.get(head);
            RandomListNode rand = nodeMap.get(head.random);
            cur.random = rand;
            head = head.next;
        }
        return newHead;
    }

    public RandomListNode copyRandomListHelper(RandomListNode head){
        if (head == null)
            return null;
        RandomListNode next = copyRandomListHelper(head.next);
        RandomListNode cur = new RandomListNode(head.label);
        cur.next = next;
        nodeMap.put(head, cur);
        return cur;
    }

    public RandomListNode copyRandomList(RandomListNode head){
        if (head == null){
            return null;
        }
        RandomListNode cur = head;
        // copy every node and insert after the original node in place
        while (cur != null){
            RandomListNode curNext = cur.next;
            RandomListNode newNode = new RandomListNode(cur.label);
            cur.next = newNode;
            newNode.next = curNext;
            cur = curNext;
        }
        // add random attr
        cur = head;
        while (cur != null){
            RandomListNode newNode = cur.next;
            RandomListNode curRand = cur.random;
            // note here that the random could be null, so avoid null pointer
            RandomListNode newRand = curRand == null ? null : curRand.next;
            newNode.random = newRand;
            cur = cur.next.next;
        }
        // restore original list and produce new list
        cur = head;
        RandomListNode newHead = head.next;
        while (cur != null){
            RandomListNode newNode = cur.next;
            cur.next = newNode.next;
            if (newNode.next != null){
                newNode.next = newNode.next.next;
            }
            cur = cur.next;
        }
        return newHead;
    }
}
