state : how many ways to fill in amount of i
public class Solution {
    /**
     * @param nums an integer array and all positive numbers, no duplicates
     * @param target an integer
     * @return an integer
     */
    public int backPackIV(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[][] f = new int[nums.length + 1][target + 1];
        //only one way, put nothing
        for (int i = 0; i <= nums.length; i++) {
            f[i][0] = 1;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
            // we can put same item several times
                int k = 0;
                while (k * nums[i - 1] <= j) {
                    f[i][j] += f[i - 1][j - nums[i - 1] * k];
                    k++;
                }
            }
        }
        return f[nums.length][target];
    }
}
