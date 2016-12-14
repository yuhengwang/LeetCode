public class Solution {
    public boolean isSymmetric(TreeNode root) {
        
    if(root ==null)
    return true;
        TreeNode leftTree = root.left;
        TreeNode rightTree = root.right;
        
      return isSymmetricHelper(leftTree,rightTree);
        
        
        
    }
    
    public boolean isSymmetricHelper(TreeNode leftTree, TreeNode rightTree){
         if(leftTree==null||rightTree==null)
        return leftTree == rightTree;
        
        if(leftTree.val!=rightTree.val)
        return false;
        
        return isSymmetricHelper(leftTree.left,rightTree.right)&&isSymmetricHelper(leftTree.right,rightTree.left);
        
        
    }
}
