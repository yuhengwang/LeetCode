inorder traversal
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
    Integer prev = null;
    int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return min;
        getMinimumDifference(root.left);
        if (prev != null) {
            min = Math.min(min, Math.abs(root.val - prev));
        }
        prev = root.val;
        getMinimumDifference(root.right);
        return min;
    }
    
}
