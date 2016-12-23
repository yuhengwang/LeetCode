public class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int [] results = new int[2];
        HashMap <Integer,Integer> maps = new HashMap<>();
        for(int i=0; i<nums.length;i++) {
            if(maps.containsKey(target-nums[i])) {
                results[1] = i;
                results[0] = maps.get(target-nums[i]);
                return results;
            }
            
            maps.put(nums[i],i);
        }
        
        return results;
        
    }
}
