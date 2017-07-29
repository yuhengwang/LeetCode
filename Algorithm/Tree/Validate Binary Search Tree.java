// we not only need to test each small tree order, we need to consider the whole left subtree and the whole
right subtree order with the root node, hence we need to define the range of value for all the subtree node
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return validBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean validBST(TreeNode root, long min, long max) {
    //define all the return condition
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) return false; //if return true is not applicable try return false;
        return validBST(root.left, min, root.val) && validBST(root.right, root.val, max);   
    }
}
