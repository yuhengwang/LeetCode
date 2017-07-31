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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, "");
        return sum;
    }
    public void dfs(TreeNode root, String path) {
        if (root.left == null && root.right == null) {
            int n = Integer.parseInt(path + root.val);
            sum += n;
            return;
        }
        if (root.left != null)
            dfs(root.left, path + root.val);
        if (root.right != null)
            dfs(root.right, path + root.val);
    }
}
