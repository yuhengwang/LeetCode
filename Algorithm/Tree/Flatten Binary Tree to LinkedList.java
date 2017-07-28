// we can first analyze the smallest tree with only one parent and two children, then we can have a basic idea of how the program goes
public class Solution {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        flatten(left);
        flatten(right);
        TreeNode cur = root;
        cur.right = left;
        cur.left = null;
        while (cur.right != null) cur = cur.right;
        cur.right = right;
    }
}
