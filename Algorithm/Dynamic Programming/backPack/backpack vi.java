Given an integer array nums with all positive numbers and no duplicates, find the number of possible combinations 
that add up to a positive integer target
differnet order considered as different combination
public class Solution {
    /**
     * @param nums an integer array and all positive numbers, no duplicates
     * @param target an integer
     * @return an integer
     */
    public int backPackVI(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] f = new int[target + 1];
        f[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    f[i] += f[i - nums[j]];
                }
            }
        }
        return f[target];
    }
}
