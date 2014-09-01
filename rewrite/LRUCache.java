import java.util.HashMap;

class Node {
    Node prev;
    Node next;
    int key;
    int val;
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class LRUCache {
    private HashMap<Integer, Node> nodeMap;
    private Node first;
    private Node last;
    private int capacity;
    private int cnt;

    public LRUCache(int capacity) {
        nodeMap = new HashMap<Integer, Node>();
        first = last = null;
        this.capacity = capacity;
        cnt = 0;
    }

    public int get(int key) {
        if (nodeMap.containsKey(key)) {
            Node cur = nodeMap.get(key);
            updateNode(cur.key, cur.val);
            return cur.val;
        } else
            return -1;
    }

    public void set(int key, int value) {
        if (nodeMap.containsKey(key)) {
            updateNode(key, value);
        } else {
            // new key
            addNew(key, value);
        }
    }

    private void updateNode(int key, int value) {
        remove(key);
        addNew(key, value);
    }

    private void addNew(int key, int value) {
        Node cur = new Node(key, value);
        nodeMap.put(key, cur);
        if (cnt == capacity) {// full
            // remove first
            remove(first.key);
        }
        if (first == null) {
            first = last = cur;
        } else {
            last.next = cur;
            cur.prev = last;
            last = cur;
        }
        cnt++;
    }

    private void remove(int key) {
        Node node = nodeMap.get(key);
        Node prev = node.prev;
        Node next = node.next;
        if (prev != null) prev.next = next;
        if (next != null) next.prev = prev;
        // update first/last
        if (node == first) {
            first = first.next;
            if (first == null) last = null;
        }
        if (node == last) last = last.prev;
        nodeMap.remove(new Integer(key));
        cnt--;
    }
}