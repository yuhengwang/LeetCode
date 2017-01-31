/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    TreeNode ans = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        // root or left, root or right
        if (root == null || p == null) {
            return null;
        }
        if (p.right != null) {
            ans = helper(p.right);
        }
        if (p.right == null) {
            ans = helper2(root, p);
        }
        return ans;
    }
    // find the leftmost treenode in the subtree
    public TreeNode helper(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
    // there is no right subtree
    public TreeNode helper2(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while (root != null) {
            if (root.val < p.val) {
                root = root.right;
            //successor = root;
            } else if (root.val > p.val) {
                successor = root;
                root = root.left;
            } else {
                break;
            }
        }
        return successor;
    }
}
