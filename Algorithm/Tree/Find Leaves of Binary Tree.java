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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        while (root != null) {
            List<Integer> leaves = new ArrayList<>();
            root = dfs(root, res,leaves);
            res.add(leaves);
        }
        return res;
    }
    public TreeNode dfs(TreeNode root, List<List<Integer>> res, List<Integer> leaves) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
            return null;
        }
        TreeNode left = dfs(root.left, res, leaves);
        TreeNode right = dfs(root.right, res, leaves);
        if (left == null)   root.left = null;
        if (right == null)  root.right = null;
        return root;
    }
}
