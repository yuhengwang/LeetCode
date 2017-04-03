public class Solution {
    /**
     * @param head a ListNode
     * @param k an integer
     * @return a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
       ListNode dummy = new ListNode(0);
       dummy.next = head;
       head = dummy;
       while (head != null) {
           head = reverseK(head, k);
           if (head == null) {
               break;
           }
       }
       return dummy.next;
    }
    
    // head -> n1 -> n2 ... nk -> nk+1
    // =>
    // head -> nk -> nk-1 .. n1 -> nk+1
    // return n1
    public ListNode reverseK(ListNode head, int k) {
        ListNode n1 = head;
        for (int i = 0; i < k; i++) {
            if (n1 == null) {
                return null;
            }
            n1 = n1.next;
        }
        if (n1 == null) {
            return null;
        }
        // reverse
        ListNode n = head.next;
        ListNode n1Next = n1.next;
        ListNode prev = null;
        ListNode curr = head.next;
        while (curr != n1Next) {
            ListNode t = curr.next;
            curr.next = prev;
            prev = curr;
            curr = t;
        }
        //connect
        head.next = n1;
        n.next = n1Next;
        return n;
    }
}
