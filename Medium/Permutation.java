public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> res= new ArrayList<List<Integer>> ();
        List<Integer> current = new ArrayList<Integer> ();
        

        helper(nums,current,res);
      
        return res;
        
        
        
    }
    
    
    public void helper(int [] nums, List<Integer> current, List<List<Integer>> res) {
        if(current.size() == nums.length) {
            res.add(new ArrayList<Integer>(current));
        }
        else{
        for(int i = 0; i < nums.length; i++) {
            if(current.size()!=0) {
                 if(current.contains(nums[i])) continue;
            }
           
            
            current.add(nums[i]);
            helper(nums,current,res);
            current.remove(current.size()-1);
        }
        
    }
    }
}
