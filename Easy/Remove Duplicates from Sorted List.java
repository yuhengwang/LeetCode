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
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) { 
        // write your code here
        if (head == null) {
            return null;
        }
        ListNode copy = head;
        ListNode dummy = new ListNode(0);
        dummy.next = copy;
        head = head.next;
        while (head != null) {
            while (head != null && copy.val == head.val) {
                head = head.next;
            }
            if (head == null) {
                break;
            }
            copy.next = new ListNode(head.val);
            copy = copy.next;
            head = head.next;
        }
        return dummy.next;
    }  
}
