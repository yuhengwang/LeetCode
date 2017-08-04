state: the number of ways to fill the amount i, but one item can only be used once
public class Solution {
    /**
     * @param nums an integer array and all positive numbers
     * @param target an integer
     * @return an integer
     */
    public int backPackV(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[][] f = new int[nums.length + 1][target + 1];
        for (int i = 0; i <= nums.length; i++) {
            f[i][0] = 1;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
            // add the number of ways to achieve when we do not use ith item first regardless of any other conditions
                    f[i][j] += f[i - 1][j];
                   if (j >= nums[i - 1])
                   //if we use ith item, we need to add f[i - 1][j  - nums[i - 1]] to the total number of ways to achieve amount j
                    f[i][j] += f[i - 1][j - nums[i - 1]];
            }
        }
        return f[nums.length][target];
    }
}
