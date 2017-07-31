//brute force, time complexity 2^n
public class Solution {
    int ans = 0;
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return ans;
        }
        dfs(nums, S, 0);
        return ans;
    }
    public void dfs(int[] nums, int S, int start) {

if (start == nums.length) {
            if (S == 0) {                ans += 1;
            }
            return;
        }
        //+
        dfs(nums, S - nums[start], start + 1);
        //-

dfs(nums, S + nums[start], start + 1);
    }


//recursion with memorization, time complexitiy l * n, where l is the range of sum, n is nums.length
public class Solution {
    
    public int findTargetSumWays(int[] nums, int S) {
        int[][] memo = new int[nums.length][2001];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = dfs(nums, S, 0, 0, memo);
        return res == Integer.MIN_VALUE ? 0 : res;
    }
    public int dfs(int[] nums, int S, int index, int sum, int[][] memo) {
        if (index == nums.length) {
            if (sum == S)
                return 1;
            else
                return 0;
        }
        if (memo[index][sum + 1000] != Integer.MIN_VALUE) {
            return memo[index][sum + 1000];
        }
        int add = dfs(nums, S, index + 1, sum + nums[index], memo);
        int substract = dfs(nums, S, index + 1, sum - nums[index], memo);
        memo[index][sum + 1000] = add + substract;
        return memo[index][sum + 1000]; 
    }
}
//2-D dp,time complexitiy l * n, where l is the range of sum, n is nums.length
public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        //dp[i][j]: up to index i, how to ways to get the sum of j
        int[][]dp = new int[nums.length][2001];
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[i - 1][sum + 1000] != 0) {
                    dp[i][sum + 1000 + nums[i]] += dp[i - 1][sum + 1000];
                    dp[i][sum + 1000 - nums[i]] += dp[i - 1][sum + 1000];
                }
            }
        }
        return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];
    }
}
//1-D dp,time complexitiy l * n, where l is the range of sum, n is nums.length
public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
      
        int[]dp = new int[2001];
        dp[nums[0] + 1000] = 1;
        dp[-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            int[] next = new int[2001];
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[sum + 1000] != 0) {
                    next[sum + 1000 + nums[i]] += dp[sum + 1000];
                    next[sum + 1000 - nums[i]] += dp[sum + 1000];
                }
            }
            dp = next;
        }
        return S > 1000 ? 0 : dp[S + 1000];
    }
}
