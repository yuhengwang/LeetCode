public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(int[] nums, int k) {
        // write your code here
        int[][] f = new int[k + 1][nums.length];
        for (int i = 1; i < k + 1; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += nums[j];
            }
            f[i][i - 1] = sum;
        }
        for (int j = 1; j < nums.length; j++) {
            f[1][j] = Math.max(f[1][j - 1] + nums[j], nums[j]);
        }
        for (int i = 2; i < k + 1; i++) {
            for (int n = i; n < nums.length; n++) {
                int curMax = f[i][n - 1] + nums[n];
                for (int j = i - 2; j < n; j++) {
                    if (f[i - 1][j] + nums[n] > curMax) {
                        curMax = f[i - 1][j] + nums[n];
                    }
                }
                f[i][n] = curMax;
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = k - 1; i < nums.length; i++) {
            res = Math.max(res, f[k][i]);
        }
        return res;
    }
}
