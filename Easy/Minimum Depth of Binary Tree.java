public class Solution {
    public int helper(TreeNode root){
        if(root == null) {
            return Integer.MAX_VALUE;
        }
        
        if(root.left == null && root.right == null) {
            return 1;
        }
        
       return Math.min(helper(root.left),helper(root.right))+1;
        
    }
    
    public int minDepth(TreeNode root) {
        
        //dfs
        if(root == null) {
            return 0;
        }
        
        return helper(root);}
}



public class Solution {
    public int minDepth(TreeNode root) {
        
          Queue <TreeNode> queue = new LinkedList <TreeNode> ();
         
          if(root == null)  return 0;
          queue.add(root);
      
          int depth =1;
          while(!queue.isEmpty()){
             
              int size = queue.size();
           
              
              for(int i=0; i <size; i++){
                  
                  TreeNode temp = queue.poll();
                  if(temp.left!=null)  queue.add(temp.left);
                  if(temp.right != null ) queue.add(temp.right);
                  if(temp.right == null && temp.left == null) return depth;
                  
              }
                depth++;
              
          }
          
          return depth;
        
    }
}
