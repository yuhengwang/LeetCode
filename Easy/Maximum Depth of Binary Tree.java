public class Solution {
    public int maxDepth(TreeNode root) {
 
       
        
        if(root == null)
          return 0;
        
        
        return 1+ Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}


//DFS
public class Solution {
    public int maxDepth(TreeNode root) {
 
       //DFS
       Stack <TreeNode> stack = new Stack <TreeNode> ();
       Stack <Integer> value = new Stack <Integer> ();
       
       if( root == null) return 0;
       
       stack.push(root);
       value.push(new Integer(1));
       
       int max = 0;
       
       while(!stack.isEmpty()){
           TreeNode temp = stack.pop();
           
           int tempValue = value.pop();
           max = Math.max(max,tempValue);
           
           if(temp.left != null){
               
               value.push(new Integer(tempValue+1));
               stack.push(temp.left);
               
           }
           
           if(temp.right != null){
               value.push(new Integer (tempValue+1));
               stack.push(temp.right);
           }
           
           
       }
       
       return max;
    }
}
