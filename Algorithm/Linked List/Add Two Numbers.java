/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        ListNode list = new ListNode(0);
        ListNode temp = list;
        while (l1 != null || l2 != null) {
            if (l1 != null) {sum += l1.val; l1 = l1.next;}
            if (l2 != null) {sum += l2.val; l2 = l2.next;}
            list.val = sum % 10;
            if (l1 != null || l2 != null || sum / 10 != 0)
                list.next = new ListNode(sum / 10);
            list = list.next;
            sum /= 10;
        }
        return temp;
    }
}
