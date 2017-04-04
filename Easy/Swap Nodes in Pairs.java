/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @return a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        // Write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (head != null && head.next != null && head.next.next != null) {
        ListNode n1 = head.next;
        ListNode n2 = head.next.next;
        ListNode n2Next = n2.next;
        //reverse n1 and n2
        n2.next = n1;
        //connect
        n1.next = n2Next;
        head.next = n2;
        // update head
        head = n1;
        }
        return dummy.next;
        
        
    }
}
