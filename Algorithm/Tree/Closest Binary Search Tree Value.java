/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
the thinking process is similar as the lca of the BST
class Solution {
    double min = Double.MAX_VALUE;
    public int closestValue(TreeNode root, double target) {
        traverse(root, target);
        return (int)min;
    }
    public double traverse(TreeNode root, double target) {
         if (root == null)   return Double.MAX_VALUE;
         if (Math.abs(root.val - target) < Math.abs(min - target))
                min = root.val;
        if (root.val > target) {
            double c = traverse(root.left, target);
            if (Math.abs(target - c) < Math.abs(min - target))
                min = c;
        } else {
            double c = traverse(root.right, target);
            if (Math.abs(target - c) < Math.abs(min - target))
                min = c;
        }
        return root.val;
    }
}
