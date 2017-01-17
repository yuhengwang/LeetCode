public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>> ();
        
        List <Integer> current = new ArrayList <Integer>();
        
        Arrays.sort(candidates);
        
        helper(candidates,target,current,res,0);
        
        return res;
        
    }
    
   public void helper(int [] candidates, int target, List <Integer> current, List <List<Integer>> res, int start) {
       
         if(target > 0) {
             for(int i = start; i < candidates.length && target >= candidates[i];i++) {
                 current.add(candidates[i]);
                 helper(candidates,target - candidates[i],current,res,i+1);
                 current.remove(current.size()-1);
             }
             
         }
         
         if(target == 0){
             if(!res.contains(current))
             res.add(new ArrayList<Integer>(current));
             return;
             
         }
         
         if(target < 0) {
             return;
         }
       
       
   }
}
