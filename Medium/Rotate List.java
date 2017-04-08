/**
 * Definition for singly-linked list.
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
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        // write your code here
        if (head == null) {
            return null;
        }
        if (k <= 0) {
            return head;
        }
        ListNode tail = head;
        ListNode end = head;
        for (int i = 0; i < k; i++) {
            if (end == null) {
                end = head;
            }
            end = end.next;
        }
        if (end == null) {
            return head;
        }
        while (end.next != null) {
            end = end.next;
            tail = tail.next;
        }
        ListNode newHead = tail.next;
        tail.next = null;
        end.next = head;
        return newHead;
        
    }
}
