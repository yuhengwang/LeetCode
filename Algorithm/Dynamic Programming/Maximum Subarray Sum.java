dp[i] means if the last element is nums[i], the maximum sum is dp[i]
public class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);// whether start with nums[i] or ends with nums[i]
            max = Math.max(dp[i], max);
        }
        return max;
        
    }
}
