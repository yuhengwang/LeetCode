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
     * @return a boolean
     */
    public boolean isPalindrome(ListNode head) {
        // Write your code here
        if (head == null) {
            return true;
        }
        ListNode middle = findMiddle(head);
        middle.next = reverse(middle);
        ListNode mid = middle.next;
        while (head != null && mid != null && mid.val == head.val) {
            head = head.next;
            mid = mid.next;
        }
        return mid == null;
        
    }
    public ListNode reverse(ListNode middle) {
        ListNode prev = null;
        ListNode cur = middle.next;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
        
    }
    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
