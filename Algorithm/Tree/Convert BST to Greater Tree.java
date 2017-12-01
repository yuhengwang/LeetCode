/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //reverse inorder traversal
class Solution {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        //reverse inorder traversal
        convert(root);
        return root;
    }
    public void convert(TreeNode cur) {
        if (cur == null) {
            return;
        }
        convert(cur.right);
        cur.val += sum;
        sum = cur.val;
        convert(cur.left);
    }
}
