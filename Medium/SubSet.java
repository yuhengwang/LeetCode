public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        
        helper(nums,current,res,0);
        return res;
        
        
    }
    
    
    public void helper(int [] nums, List<Integer> current,List<List<Integer>> res,int start) {
        
       res.add(new ArrayList<Integer>(current));
       for(int i = start; i < nums.length; i++) {
           current.add(nums[i]);
           helper(nums,current,res,i+1);
           current.remove(current.size()-1);
       }
       
    }
}
