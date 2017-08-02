
Time complexity : O(S∗n). where S is the amount, n is denomination count. 
In the worst case the recursive tree of the algorithm has height of S and the algorithm solves only S subproblems 
because it caches precalculated solutions in a table. Each subproblem is computed with n iterations, 
one by coin denomination. Therefore there is O(S∗n) time complexity.

Space complexity : O(S), where S is the amount to change We use extra space for the memoization table


public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 1) {
            return 0;
        }
        //state: the minimum number of coins used in get the amount of i
        int[] dp = new int[amount];
        return calculate(coins, amount, dp);
    }
    //backtracking
    public int calculate(int[] coins, int res, int[] dp) {
        if (res < 0) {
            return -1;
        }
        if (res == 0) {
            return 0;
        }
        //memorized searching
        if (dp[res - 1] != 0) {
            return dp[res - 1];
        }
        int min = Integer.MAX_VALUE; //minimum number of coins to get the value
        //iterate over coins array to get the minimum number of coins to achieve the result
        for (int money : coins) {
           int result = calculate(coins, res - money, dp);
           if (result >= 0 && result < min) {
               min = 1 + result;
           }
        }
        dp[res - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return dp[res - 1];
    }
}
