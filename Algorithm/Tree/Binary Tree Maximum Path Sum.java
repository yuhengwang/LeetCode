
 //Path sum : The child node has to be connected by the parent node, all path will be like starting from the root node, go up for 
 // several steps, and go down for several steps
public class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return max;
    }
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, dfs(root.left)); // if the left max sum is smaller than 0, we will omit this branch
        int right = Math.max(0, dfs(root.right));
        max = Math.max(max, left + right + root.val);
        return Math.max(left, right) + root.val; // for the grandparent node to select the branch with maximum sum
    }
}
