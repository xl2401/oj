import java.util.HashMap;

class Node{
    int key;
    int val;
    Node prev = null;
    Node next = null;

    public Node(int key, int value, Node prev, Node next){
        this.key = key;
        this.val = value;
        this.prev = prev;
        this.next = next;
    }
}

/*
 * Title:
 * LRU Cache
 * Description:
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * Solution:
 * Use HashMap
 * maintain double linked list inside the object in HashMap
 * a little bit tricky
 */
public class LRUCache {
    private int capacity = 0;
    private int count = 0;
    private Node first = null;
    private Node last = null;
    private HashMap<Integer, Node> map = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
        if (map.containsKey(key)){
            // put the key node to first
            Node n = map.get(key);
            if (n != first){
                // special condition, if the current node is last,
                // last should be updated
                if (n.next == null){
                    last = n.prev;
                }
                Node prev = n.prev;
                Node next = n.next;
                if (prev != null)
                    prev.next = next;
                if (next != null)
                    next.prev = prev;
                first.prev = n;
                n.next = first;
                first = n;
            }
            return n.val;
        }
        else
            return -1;
    }
    
    public void set(int key, int value) {
        if (!map.containsKey(key)){
            Node n = null;
            if (count == capacity){// full, delete LRU
                map.remove(last.key);
                // reuse deleted node
                Node deleted = last;
                last = last.prev;
                if (last != null)
                    last.next = null;
                else
                    first = null;
                count--;
                
                deleted.prev = null;
                deleted.next = first;
                deleted.key = key;
                deleted.val = value;
                n = deleted;
            }
            if (n == null){
                n = new Node(key, value, null, first);
            }
            // insert at head
            if (first == null){
                last = n;
            }
            else{
                first.prev = n;
            }
            first = n;
            map.put(key, n);
            count++;
        }
        else{
            map.get(key).val = value;
            // update
            this.get(key);
        }
    }

    public static void main(String[] args){
        LRUCache cache = new LRUCache(2);
        cache.set(2,1);
        cache.set(1,1);
        cache.set(2,3);
        cache.set(4,1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
