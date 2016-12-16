public class Solution {
    
     public int maxDepth(TreeNode root) {
 
       
        
        if(root == null)
          return 0;
        
        
        return 1+ Math.max(maxDepth(root.left),maxDepth(root.right));
    }
    
    
    public boolean isBalanced(TreeNode root) {
        
        if(root == null)
          return true;
       
       int left = maxDepth(root.left);
       int right = maxDepth(root.right);
       
       
       return Math.abs(left-right)<=1&&isBalanced(root.left)&&isBalanced(root.right);
      
       
        
        
        
        
    }
}

//another solution
public class Solution {
    
     public int Depth(TreeNode root) {

        if(root == null)
          return 0;
    
        int left = Depth(root.left);
    
        if(left == -1)  return -1;
        
        int right = Depth(root.right);
       
        if(right == -1)  return -1;
        
        if(Math.abs(left-right)>1)
         return -1;
         
        return Math.max(left,right)+1;
        
        
      
    }
    
    
    public boolean isBalanced(TreeNode root) {
        
        if(root == null)
          return true;
       
   
       
       
       return Depth(root)!=-1;
      
       
        
        
        
        
    }
}
