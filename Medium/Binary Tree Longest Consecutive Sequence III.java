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
    private class ResultType {
        int max_down;
        int max_up;
        int max_length;
        public ResultType(int down, int up, int length) {
            max_down = down;
            max_up = up;
            max_length = length;
        }
    }
    /**
     * @param root the root of binary tree
     * @return the length of the longest consecutive sequence path
     */

    public int longestConsecutive2(TreeNode root) {
        // Write your code here
        if (root == null) {
            return 0;
        }
        return helper(root).max_length;
        
    }
    public ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0, 0);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        int down = 0;
        int up = 0;
        if (root.left != null && root.left.val - 1 == root.val) {
            up = Math.max(left.max_up + 1, up);
        }
        if (root.left != null && root.left.val + 1 == root.val) {
            down = Math.max(left.max_down + 1, down);
        }
        if (root.right != null && root.right.val + 1 == root.val) {
            down = Math.max(right.max_down + 1, down);
        }
        if (root.right != null && root.right.val - 1 == root.val) {
            up = Math.max(right.max_up + 1, up);
        }
        int len = Math.max(up + down + 1, Math.max(left.max_length, right.max_length));
        return new ResultType(down, up, len);

    }
}
