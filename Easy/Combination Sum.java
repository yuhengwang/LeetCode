public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        if(candidates == null)  return null;
        
        List<List<Integer>> res = new ArrayList<List<Integer>> ();
        List <Integer> current = new ArrayList<Integer> ();
        
        Arrays.sort(candidates);
        
        helper(candidates,target,0,current,res);
        
        return res;
        
    }
    
    
    public void helper(int [] candidate, int target, int start, List <Integer> current,List<List<Integer>> res) {
        
        if(target > 0) {
            for(int i = start; i < candidate.length && target >= candidate[i]; i++) {
            
                current.add(candidate[i]);
            
                helper(candidate, target - candidate[i], i, current, res);
             
                current.remove(current.size()-1);
            }
        }
        
        if(target == 0) {
            res.add(new ArrayList<Integer>(current));
        
            return;
        }
        if(target < 0) {
         
            return;
        }
        
        
    }
}
