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
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        if (l1 == null || l2 == null) {
            return null;
        }
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode point = head;
        while (l1 != null && l2 != null) {
            int sum = carry + l1.val + l2.val;
            point.next = new ListNode(sum % 10);
            carry = sum / 10;
            point = point.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = carry + l1.val;
            point.next = new ListNode(sum % 10);
            carry = sum / 10;
            point = point.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = carry + l2.val;
            point.next = new ListNode(sum % 10);
            carry = sum / 10;
            point = point.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            point.next = new ListNode(carry);
        }
        return head.next;
    }
   
}
