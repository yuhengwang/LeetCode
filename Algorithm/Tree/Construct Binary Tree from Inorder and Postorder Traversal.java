//the last element of the postorder is root element, and find this element in inorder array, the left part would be in the left subtree,
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = null;
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
            return root;
        }
        return dfs(0, inorder.length - 1, 0, postorder.length - 1, inorder, postorder);
    }
    public TreeNode dfs(int instart, int inend, int poststart, int postend, int[] inorder, int[] postorder) {
        if (instart > inend || poststart > postend) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postend]);
        int inindex = 0;
        for (int i = instart; i <= inend; i++) {
            if (postorder[postend] == inorder[i]) {
                inindex = i;
                break;
            }
        }
      
        root.left = dfs(instart, inindex - 1, poststart, poststart + inindex - instart - 1, inorder, postorder);
        root.right = dfs(inindex + 1, inend, poststart + inindex - instart, postend - 1, inorder, postorder);
        return root;
    }
}
 
