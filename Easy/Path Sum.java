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
    public boolean hasPathSum(TreeNode root, int sum) {
        
        if(root == null) {
            return false;
        }
        
        return helper(root,0,sum);
    }
    
    public boolean helper(TreeNode root, int sum, int threshold) {
        
        if(root == null) {
            return false;
        }
        
        if(root.left == null && root.right == null) {
            
            sum += root.val;
            
            if(threshold == sum) 
            return true;
            else
            return false;
        }
        
        return helper(root.left,sum+root.val,threshold)||helper(root.right,sum+root.val,threshold);
        
    }
}
