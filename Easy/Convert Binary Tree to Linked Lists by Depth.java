/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @return a lists of linked list
     */
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        // Write your code here
        if (root == null) {
            return new ArrayList<ListNode>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<ListNode> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode dummy = new ListNode(0);
            ListNode temp = dummy;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                temp.next = new ListNode(cur.val);
                temp = temp.next;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
             }
             res.add(dummy.next);
        }
        // while (!queue.isEmpty()) {
        //     int size = queue.size();
        //     ListNode dummy = new ListNode(0);
        //     ListNode temp = dummy;
        //     for (int i = 0; i < size; i++) {
        //         TreeNode cur = queue.poll();
        //         if (cur == null && temp == dummy) { //新的一层里，一直都是null，没出现过node
        //             continue;
        //         }
        //         if (cur == null && queue.size() > 0) {//新的一层中，中间有null，或者最后一层有null，但内容还没完
        //             continue;
        //         }
        //         if (cur == null && queue.size() == 0) {//最后一个空元素
        //             res.add(dummy.next);
        //             return res;
        //         }
               
        //         temp.next = new ListNode(cur.val);
        //         temp = temp.next;
        //         queue.offer(cur.left);
        //         queue.offer(cur.right);
        //     }
            
        //     if (temp == dummy) {
        //         return res;
        //     }
        //     res.add(dummy.next);
           
        // }
        return res;
    }
}
