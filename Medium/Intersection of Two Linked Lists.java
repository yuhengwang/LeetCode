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
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode 
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Write your code here
        // find the end
        if (headA == null || headB == null) {
            return null;
        }
        ListNode endC = headA;
        while (endC.next != null) {
            endC = endC.next;
        }
        endC.next = headA;
        //change the question to linked cycle
        ListNode slow = headB;
        ListNode fast = headB.next;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //
        while (slow.next != headB) {
            slow = slow.next;
            headB = headB.next;
        }
        return headB;
    }  
}
