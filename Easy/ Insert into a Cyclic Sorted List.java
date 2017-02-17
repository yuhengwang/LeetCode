/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param node a list node in the list
     * @param x an integer
     * @return the inserted new list node
     */
    public ListNode insert(ListNode node, int x) {
        // Write your code here
        if(node == null) {
            ListNode newNode = new ListNode(x);
            newNode.next = newNode;
            return newNode;
        }
        ListNode inserted = new ListNode(x);
        ListNode orig = node;
        do {
            int prev = node.val;
            int next = node.next.val;
            if (prev <= x && next >= x) {
                break;
            } 
            node = node.next;
        } while(orig != node);
        // some listnode has only one element calling itself
        ListNode temp = node.next;
        node.next = inserted;
        inserted.next = temp;
        return inserted; 
    }
}
