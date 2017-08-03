//int[][]dp : the maximum value get from ith to jth balloon, but ith and jth are also considered as potential burst balloon
public class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        return burst(dp, nums, visited, 0, n - 1);
    }
    public int burst(int[][] dp, int[] nums, boolean[][] visited, int i, int j) {
        if (j < i) {
            return 0;
        }
        if (visited[i][j]) {
            return dp[i][j];
        }
        visited[i][j] = true;
        if (i == j) {
            int value = getValue(i - 1, nums) * getValue(i, nums) * getValue(i + 1, nums);
            dp[i][j] = value;
            return dp[i][j];
        }
        int max = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            //the left boundary should not be k - 1 or k + 1but i - 1 and j + 1
            int value = getValue(i - 1, nums) * getValue(j + 1, nums) * getValue(k, nums);   
            max = Math.max(max, value + burst(dp, nums, visited, i, k - 1) + burst(dp, nums, visited, k + 1, j));
        }
        dp[i][j] = max;
        return dp[i][j];
    }
    public int getValue(int i, int[] nums) {
        if (i < 0 || i >= nums.length) {
            return 1;
        } else {
            return nums[i];
        }
    }
    
}


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
