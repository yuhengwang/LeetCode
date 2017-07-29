
//smart solution, omit dealing with divide one linkedlist to two linked list

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return dfs(head, null);
    }
    //indicate the head and the tail we goona search from the linkedlist
    public TreeNode dfs(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = dfs(head, slow);
        root.right = dfs(slow.next, tail);
        return root;
    }
}



// similar to convert sorted array to binary search Tree, this is direct translation from the code from array to linkedlist
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return dfs(head);
    }
    public TreeNode dfs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy = head;
        ListNode middle = findMiddle(head);
        ListNode left = head;
        ListNode right = head;
        while (right != middle) {
            right = right.next;
        }
        while (left != null && left.next != middle) {
            left = left.next;
        }
        
        TreeNode root = new TreeNode(middle.val);
        
        if (left != null) {
            left.next = null;
            root.left = dfs(head);
        }
        //right == middle
        if (right != null)
            root.right = dfs(right.next);
        
        return root;
    }
    //classic find middle!
    public ListNode findMiddle(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
