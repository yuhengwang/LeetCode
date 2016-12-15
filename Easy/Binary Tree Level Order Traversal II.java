public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue <TreeNode> queue = new LinkedList <TreeNode> ();
        Stack <TreeNode> stack = new Stack <TreeNode> ();
        Stack <Integer> value = new Stack <Integer> ();
        
        List <List<Integer>> answers = new ArrayList <List<Integer>> ();
        if(root == null)
          return answers;
         
      queue.add(root);
      stack.push(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            value.push(size);
            for(int i=0;i < size;i++){
                
                root = queue.poll();
                
                 if(root.right != null) {
                    queue.add(root.right);
                    stack.push(root.right);
                }
                
                if(root.left != null)  {
                    queue.add(root.left);
                    stack.push(root.left);}
                    
               
                
                
                
            }
            
        }
       
       while(!stack.isEmpty()&&!value.isEmpty()){
           
            List < Integer> sublists = new ArrayList <Integer> ();
            int currentSize = value.pop();
           for(int i=0;i<currentSize;i++){
              
               sublists.add(stack.pop().val);
               
               
           }
           
           answers.add(sublists);
           
       }
        
        
        
        return answers;
        
    }
}
