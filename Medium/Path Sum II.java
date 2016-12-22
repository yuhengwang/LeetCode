public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        List <List<Integer>> ans = new ArrayList <>();
        
        List <Integer> path = new ArrayList <>();
        
        
        
        if(root == null) {
            return ans;
        }
        
     //    path.add(root.val);
         
         helper(root, path, ans,0,sum);
         
         return ans;
    }
    
    public void helper(TreeNode root, List <Integer> path, List<List<Integer>> ans,int sum, int threshold) {
         if(root == null) {
             return;
         }
         if(root.left == null && root.right == null) {
             sum += root.val;
             path.add(root.val);
             if(sum == threshold) {
                 ans.add(path);
                 return;
             }
         }
         
         path.add(root.val);
     //    System.out.println(path);
         ArrayList original = new ArrayList(path);
         helper(root.left,path,ans,sum+root.val,threshold);
         helper(root.right,original,ans,sum+root.val,threshold);
        
        
        
        
    }
}
