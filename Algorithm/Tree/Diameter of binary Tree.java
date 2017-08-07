//this question is likely the maximum depth of binary tree
public class Solution {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        caculate(root);
        return max;
        
    }
    public int caculate(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left =  caculate(root.left);
        int right =  caculate(root.right);
        max = Math.max(left + right, max);
        return Math.max(left, right) + 1;
    }
}
