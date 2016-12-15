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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        Queue <TreeNode> queue = new LinkedList <TreeNode> ();
        List<List<Integer>> lists = new ArrayList <List<Integer>> ();
        
        if(root == null)
         return lists;
         
        queue.add(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List <Integer> subLists = new ArrayList <Integer>();
            for(int i=0;i < levelNum;i++){
                if(queue.peek().left != null) queue.add(queue.peek().left);
                if(queue.peek().right != null) queue.add(queue.peek().right);
                
                subLists.add(queue.poll().val);
            }
            lists.add(subLists);
            
        }
       return lists; 
        
    }
}
