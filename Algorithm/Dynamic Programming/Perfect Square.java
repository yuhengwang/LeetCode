//exactly same with coin change
public class Solution {
    public int numSquares(int n) {
        //state: minimum number of perfect square numbers to achieve this value
        int[] dp = new int[n + 1];
        return search(dp, n);
    }
    public int search(int[] dp, int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 0) {
            return 0;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            int result = search(dp, n - i * i);
            if (result >= 0 && result < min) {
                min = result + 1;
            }
        }
        dp[n] = min == Integer.MIN_VALUE ? -1 : min;
        return dp[n];
    }
}
