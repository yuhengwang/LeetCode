public class Solution {
    public int majorityElement(int[] nums) {
        
        int n = nums.length;
        int limit = n/2;
        
        if(limit == 0) {
            return nums[0];
        }
        
        Arrays.sort(nums);
        return nums[limit];
        
    }
}
