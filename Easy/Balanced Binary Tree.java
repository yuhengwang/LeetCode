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
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    // depth, isbalance
    private class ResultType {
        public int depth;
        public boolean isbalance;
        public ResultType (int depth, boolean isbalance) {
            this.depth = depth;
            this.isbalance = isbalance;
        }
    }
    public boolean isBalanced(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        return helper(root).isbalance;
    }
    public ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, true);
        }
        if (root.left == null && root.right == null) {
            return new ResultType(1, true);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        ResultType result = new ResultType (Math.max(left.depth, right.depth) + 1, left.isbalance && right.isbalance && Math.abs(left.depth - right.depth) <= 1);
       
        return result;
    }
}
