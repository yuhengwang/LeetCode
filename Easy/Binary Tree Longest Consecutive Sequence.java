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
    /**
     * @param root the root of binary tree
     * @return the length of the longest consecutive sequence path
     */
    private int longest = 0;
    public int longestConsecutive(TreeNode root) {
        // Write your code here
        if (root == null) {
            return 0;
        }
        helper(root);
        return longest;
    }
    // return the length of the sequence
    public int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }
        // if left and right are leaf node || root is leaf node
        int left = helper(root.left);
        int right = helper(root.right);
        int subTreeLongest = 1;
        if (root.left != null && root.val + 1 == root.left.val) {  // not null need to at the first place
           subTreeLongest = Math.max(left + 1, subTreeLongest);
        }
        if (root.right != null && root.val + 1 == root.right.val) {
            subTreeLongest = Math.max(right + 1, subTreeLongest);
        }
        if (subTreeLongest > longest) {
            longest = subTreeLongest;
        }
        return subTreeLongest;
        
    }
}
