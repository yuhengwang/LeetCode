//leetcode 563
Divide and conquer. 
we use res to record the difference in left subtree and right subtree. Caculate sum is to return the sum of left subtree, right subtree and 
root value. 
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
    int res = 0;
    public int findTilt(TreeNode root) {
      if (root == null) {
          return 0;
      }
      caculateSum(root);
      return res;
    }
    public int caculateSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = caculateSum(root.left);
        int right = caculateSum(root.right);
        res += Math.abs(left - right);
        return left + right + root.val;
    }
}
