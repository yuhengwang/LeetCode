public class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        HashMap <Integer, Integer> maps = new HashMap <Integer,Integer> ();
        for ( int i = 0; i < nums.length; i++) {
            if(maps.containsKey(nums[i])) {
                
                return true;
            }
            maps.put(nums[i],new Integer(1));
        }
        
        return false;
        
    }
}


// time: O(N), space O(1)
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        
       Arrays.sort(nums);
       
       for(int i=0; i< nums.length -1 ; i++) {
           if(nums[i] == nums[i+1]) {
               return true;
           }
       }
     
        return false;
    }
}
