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
     * @param root the root of binary tree
     * @return the root of the minimum subtree
     */
    private TreeNode subTree = null;
    private int sum = Integer.MAX_VALUE;
    public TreeNode findSubtree(TreeNode root) {
        // Write your code here
        if (root == null) {
            return null;
        }
        caculateSum(root);
        return subTree;
       
    }
    public int caculateSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = caculateSum(root.left);
        int right = caculateSum(root.right);
        if (root.val + left + right < sum) {
            sum = root.val + left + right;
            subTree = root;
        }
        return root.val + left + right;
    }
}
