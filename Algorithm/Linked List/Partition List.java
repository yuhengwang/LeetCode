// it is different from the CC150, which in CC150, the original order is not important.
we can use two pointers point to node, which is head and tail, and insert in front of head when it is smaller than x, 
and insert after tail when it is larger than x. 
but the original order will be broken!!!!!
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode h = head;
        ListNode t = head;
        while (head != null) {
          ListNode next = head.next;
          if (head.val < x) {
            head.next = h;
            h = head;
          } else {
            tail.next = head;
            tail = head;
          }
          head = next;
        }
        tail.next = head;
        return head;
    }
}


so in this case in leetcode, we need to maintain two linkedlist, one is less than x list, another is more and equal x list. 
and in the end, we link these two lists together!
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(0);
        ListNode more = new ListNode(0);
        ListNode dummyLess = less;
        ListNode dummyMore = more;
        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = less.next;
            } else {
                more.next = head;
                more = more.next;
            }
            head = head.next;
        }
        more.next = null;
        less.next = dummyMore.next;
        return dummyLess.next;
    }
}
