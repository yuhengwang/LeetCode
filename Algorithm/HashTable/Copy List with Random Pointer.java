same as clone graph, copy edges first and then copy the neighbors
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
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode temp = head;
        while (temp != null) {
            map.put(temp, new RandomListNode(temp.label));
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            RandomListNode h = map.get(temp);
            if (temp.next != null)
                h.next = map.get(temp.next);
            if (temp.random != null)
                h.random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }
}
