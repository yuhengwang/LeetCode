/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }
        ArrayList<RandomListNode> nodes = new ArrayList<>();
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        nodes.add(head);
        map.put(head, new RandomListNode(head.label));
        int start = 0;
        while (start < nodes.size()) {
            RandomListNode point = nodes.get(start++);
            RandomListNode neighbor = point.next;
            if (neighbor == null) {
                
            } else if (!map.containsKey(neighbor)) {
                map.put(neighbor, new RandomListNode(neighbor.label));
                nodes.add(neighbor);
            }
            RandomListNode neighbor2 = point.random;
            if (neighbor2 == null) {
                continue;
            }
            if (!map.containsKey(neighbor2)) {
                map.put(neighbor2, new RandomListNode(neighbor2.label));
                nodes.add(neighbor2);
            }
        }
        // copy neighbor
        for (int i = 0; i < nodes.size(); i++) {
            RandomListNode n = map.get(nodes.get(i));
            if (nodes.get(i).next == null) {
                
            } else {
                n.next = map.get(nodes.get(i).next);
            }
            if (nodes.get(i).random == null) {
                n.random = null;
            } else {
                n.random = map.get(nodes.get(i).random);
            }
        }
        return map.get(head);
    }
}
