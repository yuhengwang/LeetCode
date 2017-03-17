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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int right = getRightHeight(root) + 1;
        int left = getLeftHeight(root) + 1;
     //   System.out.println(left);
        if (left == right) {
            return (1 << left) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
    public int getRightHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = 0;
        while (root.right != null) {
            height++;
            root = root.right;
        }
        return height;
    }
    public int getLeftHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = 0;
        while (root.left != null) {
            height++;
            root = root.left;
        }
        return height;
    }
}
