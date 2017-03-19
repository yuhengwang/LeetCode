public class Solution {
    private class Node {
        Node prev;
        Node next;
        int key;
        int value;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    HashMap<Integer, Node> maps = new HashMap<>();
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int capacity;
    // @param capacity, an integer
    public Solution(int capacity) {
        // write your code here
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    // @return an integer
    public int get(int key) {
        // write your code here
        if (!maps.containsKey(key)) {
            return -1;
        }
        // remove the node first
        Node current = maps.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        // move to tail
        addToTail(current);
        return maps.get(key).value;
        
    }
    private void addToTail(Node current) {
        current.prev = tail.prev;
        tail.prev = current;
        current.prev.next = current;
        current.next = tail;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // write your code here
        if (get(key) != -1) {
            maps.get(key).value = value;
            return;
        }
        if (maps.size() == capacity) {
            maps.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        Node current = new Node(key, value);
        maps.put(key, current);
        addToTail(current);
    }
}
