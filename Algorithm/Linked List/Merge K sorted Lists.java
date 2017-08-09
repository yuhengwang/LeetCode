

use the priorityqueue, we need to ensure only when the listnode is not null, we can add it to the priorityqueue
/**
 * Definition for singly-linked list./**
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
        return partition(lists, 0, lists.length - 1);
    }
    public ListNode partition(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        if (start < end) {
            int mid = (end - start) / 2 + start;
            ListNode l1 = partition(lists, start, mid);
            ListNode l2 = partition(lists, mid + 1, end);
            return merge(l1, l2);
        } else {
            return null;
        }
    }
    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1 == null) {
            return l2;
        }
        if (l1.val > l2.val) {
            l2.next = merge(l1, l2.next);
            return l2;
        } else {
            l1.next = merge(l1.next, l2);
            return l1;
        }
        
    }
}
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
