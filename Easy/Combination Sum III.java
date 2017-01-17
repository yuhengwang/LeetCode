public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>> ();
        List <Integer> current = new ArrayList <Integer> ();
       
        helper(n,1,k,current,res);
        return res;
        
    }
    
    public void helper(int target, int start, int k,List<Integer> current, List<List<Integer>> res) {
        
        if(target > 0) {
            for ( int i = start; i < 10;i ++) {
                current.add(i);
                helper(target - i,i+1,k,current,res);
                current.remove(current.size()-1);
                
            }
         
            
        }
        if(target == 0){
            if(current.size() == k)
                res.add(new ArrayList<Integer>(current));
            return;
        }
    }
}
