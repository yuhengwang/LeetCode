because we need to find BST, we need to record the tree smallest number and largest number. 
change size to -1 to indicate this subtree and its parent are not valid BST anymore.
because we need not track the parent node here, when we encounter null treenode, we can only put low range as Integer.MAX_VALUE, and
high range as Integer.MAX_VALUE.
to compensate it, at the final return, we need to use Math.min(root.val, left.low) as the low and Math.max(root.val, right.upper) as the high
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
    class ResultType {
        int lowRange;
        int highRange;
        int size;
        ResultType(int lowRange, int highRange, int size) {
            this.lowRange = lowRange;
            this.highRange = highRange;
            this.size = size;
        }
    }
    int max = 0;
    public int largestBSTSubtree(TreeNode root) {
        if (root == null)   return 0;
        traverse(root);
        return max;
    }
    public ResultType traverse(TreeNode root) {
        if (root == null)   return new ResultType(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        ResultType left = traverse(root.left);
        ResultType right = traverse(root.right);
        if (left.size == -1 || right.size == -1 || root.val <= left.highRange || root.val >= right.lowRange) {
            return new ResultType(0, 0, -1);
        }
        int size = left.size + right.size + 1;
        max = Math.max(size, max);
        return new ResultType(Math.min(root.val, left.lowRange), Math.max(root.val, right.highRange), size);
    }
}
