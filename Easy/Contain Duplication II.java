public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        HashMap <Integer, Integer> maps = new HashMap <Integer,Integer> ();
        for ( int i = 0; i < nums.length; i++) {
            if(maps.containsKey(nums[i])) {
                if(Math.abs(i-maps.get(nums[i])) <= k)
                return true;
                
            }
            maps.put(nums[i],new Integer(i));
        }
        
        return false;
        
    }
}
