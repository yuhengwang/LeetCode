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
     * @return the root of the maximum average of subtree
     */
  //  TreeNode maxNode;
//    int maxResult;
    private class ResultType {
        public int sum, size;
        public ResultType(int sum, int size) {
            this.sum = sum;
            this.size = size;
        }
    }
    
    private ResultType subTreeResult;
    private TreeNode subTree;
    
    public TreeNode findSubtree2(TreeNode root) {
        // Write your code here
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;   
        }
        caculateSum(root);
        return subTree;
        
    }
    public ResultType caculateSum (TreeNode root) {
        if(root == null) {
            return new ResultType(0,0);
        }
        ResultType left = caculateSum(root.left);
        ResultType right = caculateSum(root.right);
        ResultType result = new ResultType(root.val + left.sum + right.sum, 1 + left.size + right.size);
        if (subTreeResult == null || result.size * subTreeResult.sum < result.sum * subTreeResult.size) {
            subTreeResult = result;
            subTree = root;
        }
        return result;
        
    }
       
        
}
