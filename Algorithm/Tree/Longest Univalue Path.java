/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root);
        return max - 1;
    }
    public int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int count = 1;
        if (root.left != null) {
            if (root.left.val == root.val) {
                count += left;
            }
        }
        
        if (root.right != null) {
            if (root.right.val == root.val) {
                count += right;
            }
        }
        max = Math.max(max, count);
        // we need to check whether we take left and right both, we can only keep one longest path!
        return count > left + right ? (left > right ? count - right : count - left) : count;
    }
}
