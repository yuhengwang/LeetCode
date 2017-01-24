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
     * @param root The root of the binary tree.
     * @param A and B two nodes
     * @return: Return the LCA of the two nodes.
     */
    private class ResultType {
        public TreeNode node;
        public boolean a_exist;
        public boolean b_exist;
        public ResultType(TreeNode node, boolean a_exist, boolean b_exist) {
            this.node = node;
            this.a_exist = a_exist;
            this.b_exist = b_exist;
        }
    }
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root == null) {
            return null;
        }
        if (root.right == null && root.left == null) {
            return root;
        }
        ResultType res = helper(root,A,B);
        if(res.a_exist && res.b_exist) {
            return res.node;
        } else{
            return null;
        }
    }
    public ResultType helper (TreeNode root, TreeNode A, TreeNode B) {
      if (root == null) {
           return new ResultType(null, false, false);
       }
       ResultType left = helper(root.left, A, B);
       ResultType right = helper(root.right, A, B);
       boolean a = left.a_exist || right.a_exist || root == A;
       boolean b = left.b_exist || right.b_exist || root == B;
       if (root == A || root == B) {
           return new ResultType(root, a, b);
       }
       if (left.node != null && right.node != null) {
           return new ResultType(root, a, b);
       } else if (left.node != null) {
           return new ResultType(left.node, a, b);
       } else if (right.node != null) {
           return new ResultType(right.node, a, b);
       } else {
           return new ResultType(null, a, b);
       }
    }
}
