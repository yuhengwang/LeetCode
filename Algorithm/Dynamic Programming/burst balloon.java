// int[][] dp the maximum value we can get if burst balloon from ith balloon to jth balloon, ith and jth are the left and
right boundary, they are not considered as potential bursted balloon
public class Solution {
    public int maxCoins(int[] nums) {
        int[] num = new int[nums.length + 2];
        int n = 1;
        for (int x : nums) if (x > 0) num[n++] = x;
        num[0] = num[n++] = 1;
        int[][] dp = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        return burst(dp, num, 0, n - 1);
    }
    public int burst(int[][] memo, int[] nums, int left, int right) {
        if (left + 1 == right) return 0;
        if (memo[left][right] > 0) return memo[left][right];
        int ans = 0;
        for (int i = left + 1; i < right; ++i)
            ans = Math.max(ans, nums[left] * nums[i] * nums[right] 
            + burst(memo, nums, left, i) + burst(memo, nums, i, right));
        memo[left][right] = ans;
        return ans;
    }
    
}
