// time limit exceed
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
     List <Integer> res = new ArrayList <Integer> ();
     for (int i = 0; i<= nums.length - 1 ; i ++) {
         res.add(i + 1);
     }
     
     for ( int i =0 ; i <= nums.length -1 ;i ++) {
         res.remove((Integer)nums[i]);
         
     }
     
     return res;
        
        
    }
}


// use of index to record...
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
     List <Integer> res = new ArrayList <Integer> ();
     
     for (int i = 0; i<= nums.length - 1 ; i ++) {
         nums[(nums[i]-1) % nums.length] += nums.length;
     }
     
     for ( int i =0 ; i <= nums.length -1 ;i ++) {
         if(nums[i] <= nums.length) {
             res.add(i+1);
         }
         
     }
     
     return res;
        
        
    }
}
