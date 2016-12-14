public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList <Integer>();
        TreeNode current = root;
        Stack <TreeNode> globalStack = new Stack<TreeNode>();
        while(current!=null||!globalStack.isEmpty()){
            while(current!=null){
                 globalStack.push(current);
                current = current.left;
               
            }
         
            
            current = globalStack.pop();
            answer.add(current.val);
            current = current.right;
            
            
            
            
        }
        
        return answer;
        
    }
}
