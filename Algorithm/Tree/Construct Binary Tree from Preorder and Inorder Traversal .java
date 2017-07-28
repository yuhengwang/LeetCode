//the first element of the preorder is root element, and find this element in inorder array, the left part would be in the left subtree,
//the right part would be in the right subtree, when dealing with index, it is better for us to operate all start indice together, and 
//all end indice together, instead of mixed operation of start index and end index
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = null;
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return root;
        }
        return dfs(0, 0, inorder.length - 1, preorder, inorder);
    }
    public TreeNode dfs(int prestart, int instart, int inend, int[] preorder, int[] inorder) {
        if (prestart > preorder.length - 1 || instart > inend) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[prestart]);
        int divide = -1;
        for (int i = instart; i <= inend; i++) {
            if (inorder[i] == preorder[prestart]) {
                divide = i;
                break;
            }
        }
        root.left = dfs(prestart + 1, instart, divide - 1, preorder, inorder);
        root.right = dfs(prestart + divide - instart + 1, divide + 1, inend, preorder, inorder);
        return root;
    }
}
