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
