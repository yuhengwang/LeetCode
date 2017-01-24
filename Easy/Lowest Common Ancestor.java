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
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        
        if (root == null) {
            return null;
        }
        if (root.right == null && root.left == null) {
            return root;
        }
        helper(root,A,B);
        return res;
   
        
    }
    public TreeNode helper (TreeNode root, TreeNode A, TreeNode B) {
            
        if (root == null) {
            return null;
        }
        if (root.right == null && root.left == null) {
            return root;
        }
        TreeNode left = helper(root.left, A, B);
        TreeNode right = helper(root.right, A, B);
        if (((left == A || right == A ) && (left == B || right == B)) 
        || ((left == A || right == A ) && root == B) || (root == A && (left == B || right == B))) {
            res = root;
            return root;
        }
        if (left == A || right == A || root == A) {
            return A;
        }
        if (left == B || right == B || root == B) {
            return B;
        }
        return null;
        
    }
}

//
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
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
   
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        
        if (root == null) {
            return null;
        }
        if (root.right == null && root.left == null) {
            return root;
        }
        return helper(root,A,B);
    }
    public TreeNode helper (TreeNode root, TreeNode A, TreeNode B) {
        if (root == null || root == A || root == B) {
           return root;
        }
        TreeNode left = helper(root.left, A, B);
        TreeNode right = helper(root.right, A, B);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        } else {
            return null;
        }
        
    }
}
