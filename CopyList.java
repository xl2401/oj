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
 * Solution:
 * copy a linked list is easy, the problem is how to deal with the random
 * first copy without random and form a oldnode -> newnode map
 * and iterate the oldnode to add random relationship
 * don't forget the null-> null entry in the map
 */
public class CopyList {
    private HashMap<RandomListNode, RandomListNode> nodeMap = null;

    public RandomListNode copyRandomList(RandomListNode head) {
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
}
