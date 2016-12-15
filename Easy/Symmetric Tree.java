// recursion

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

// using stack
public class Solution {
    public boolean isSymmetric(TreeNode root) {
      
      // using stack
      Stack<TreeNode> globalStack = new Stack <TreeNode>();
      TreeNode left;
      TreeNode right;
      if(root == null) 
        return true;
      if(root.left != null)
      {
          
        if(root.right == null )
           return false;
        else
           globalStack.push(root.right);
           globalStack.push(root.left);
        
    }else{
        if(root.right != null )
        return false;
    }
    
    while(!globalStack.isEmpty()){
        
        if(globalStack.size()%2 != 0)
           return false;
        
        left = globalStack.pop();
        right = globalStack.pop();
        
        if(left.val!=right.val)
          return false;
        if(left.left != null){
            if(right.right == null)
               return false;
            else
               globalStack.push(left.left);
               globalStack.push(right.right);
        }else{
            if(right.right != null)
            return false;
        }
        
        if(left.right != null){
            if(right.left == null){
                return false;
            }
            else
              globalStack.push(left.right);
              globalStack.push(right.left);
        }else{
            if(right.left != null)
                return false;
        }
        
        
    }
    
    return true;
    }  
 
}
