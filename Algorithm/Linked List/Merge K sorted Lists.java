use the priorityqueue, we need to ensure only when the listnode is not null, we can add it to the priorityqueue
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        for (ListNode list : lists) {
            if (list != null)
                queue.offer(list);
        }
        while (!queue.isEmpty()) {
            ListNode curr = queue.poll();
            dummy.next = new ListNode(curr.val);
            if (curr.next != null) {
                queue.offer(curr.next);
            }
            dummy = dummy.next;
        }
        return head.next;
    }
}
