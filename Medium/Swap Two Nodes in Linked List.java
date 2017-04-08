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
     * @oaram v1 an integer
     * @param v2 an integer
     * @return a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        // Write your code here
        if (v1 == v2) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode n1Prev = dummy;
        ListNode n1Cur = head;
        ListNode n2Prev = dummy;
        ListNode n2Cur = head;
        boolean findOne = false;
        boolean findTwo = false;
        while (n1Cur != null && n2Cur != null) {
            if (n1Cur.val == v1) {
                findOne = true;
            } else {
                if (!findOne) {
                n1Prev = n1Cur;
                n1Cur = n1Cur.next;
                }
            }
            if (n2Cur.val == v2) {
                findTwo = true;
            } else {
                if (!findTwo) {
                n2Prev = n2Cur;
                n2Cur = n2Cur.next;
                }
            }
            if (findTwo && findOne) {
                break;
            }
            
        }
        if (!findTwo || !findOne) {
            return head;
        }
        ListNode n2 = n2Cur.next;
        ListNode n1 = n1Cur.next;
        if (n2Prev.val == n1Cur.val) {
            n1Prev.next = n2Cur;
            n2Cur.next = n2Prev;
            n1Cur.next = n2;
            return dummy.next;
            
        }
        if (n1Prev.val == n2Cur.val) {
            n2Prev.next = n1Cur;
            n1Cur.next = n1Prev;
            n2Cur.next = n1;
            return dummy.next;
        }
        
        n1Prev.next = n2Cur;
        n2Cur.next = n1;
        n2Prev.next = n1Cur;
        n1Cur.next = n2;
        return dummy.next;
    }
   
    
}
