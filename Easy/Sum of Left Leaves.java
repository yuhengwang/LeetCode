/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//recursive 
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        
       
        int ans = 0;
        
        if(root == null) {
            return 0;
        }
     
        if(root.left != null){
         
         if(root.left.left == null && root.left.right == null){
          
         
            ans += root.left.val;
          
         }
         
         else
            ans += sumOfLeftLeaves(root.left);
        }
         
         
         ans += sumOfLeftLeaves(root.right);
        
         return ans;
    }
    

}

// iterative
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
       int ans = 0;
       Stack <TreeNode> nodes = new Stack <TreeNode> ();
       if(root == null) {
           return 0;
       }
       
       nodes.push(root);
       
       while(!nodes.isEmpty()) {
           TreeNode node = nodes.pop();
           if(node == null){
               continue;
           }
         
           if(node.left != null){
               if(node.left.left == null && node.left.right == null) {
                   
                   ans += node.left.val;
               }
               else{
               nodes.push(node.left);
           }
           }
           
           nodes.push(node.right);
       }
       
       return ans;
       
    }
    

}
