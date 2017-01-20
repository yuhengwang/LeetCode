public class Solution {
    /**
     * @param nums an integer array
     * @param target an integer
     * @return the difference between the sum and the target
     */
    public int twoSumCloset(int[] nums, int target) {
        // Write your code here
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int difference = Integer.MAX_VALUE;
        while (i < j) {
            if (nums[i] + nums[j] == target) {
                return 0;
            } else if (nums[i] + nums[j] < target) {
                if (difference > Math.abs(target - nums[i] - nums[j])) {
                    difference = Math.abs(target - nums[i] - nums[j]);
                }
                i++;
            } else {
                if (difference > Math.abs(target - nums[i] - nums[j])) {
                    difference = Math.abs(target - nums[i] - nums[j]);
                }
                j--;
            }
        }
        return difference;
    }
}
