public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int pairs = 0;
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            while (low < high && nums[low] + nums[high] > target) {
                pairs++;
                high--;
            }
            low++;
            high = nums.length - 1;
        }
        return pairs;
        
    }
}
