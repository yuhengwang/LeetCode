/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        if (lists == null || lists.size() == 0) {
            return null;
        }
        return mergeList(lists, 0, lists.size() - 1);
    }
    private ListNode mergeList(List<ListNode> lists, int start, int end) {
        if (start == end) {
            return lists.get(start);
        }
        int mid = start + (end - start) / 2;
        ListNode left = mergeList(lists, start, mid);
        ListNode right = mergeList(lists, mid + 1, end);
        return merge(left, right);
        
    }
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                tail.next = new ListNode(left.val);
                left = left.next;
            } else {
                tail.next = new ListNode(right.val);
                right = right.next;
            }
            tail = tail.next;
        }
        if (left != null) {
            tail.next = left;
        }
        if (right != null) {
            tail.next = right;
        }
        return dummy.next;
    }
}
