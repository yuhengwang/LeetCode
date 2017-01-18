public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>> ();
        List<Integer> current = new ArrayList<Integer> ();
        boolean [] used = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums,res,current,used);
        return res;
        
    }
    
    public void helper(int [] nums, List<List<Integer>> res, List<Integer> current, boolean [] used) {
        
        if(current.size() == nums.length) {
            res.add(new ArrayList<Integer>(current));
            
        }else{
            for(int i = 0; i < nums.length; i++){
                
                if(used[i] == true || i > 0 && nums[i] == nums[i-1] && used[i-1] == false)  continue;
                current.add(nums[i]);
                used[i] = true;
             
                helper(nums,res,current,used);
                current.remove(current.size()-1);
              
                used[i] = false;
                
                
                
            }
            
            
        }
        
    }
}
