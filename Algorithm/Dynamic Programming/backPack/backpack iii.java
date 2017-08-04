//differen from backpack ii is that we use the same item for infinite times
public class Solution {
    /**
     * @param A an integer array
     * @param V an integer array
     * @param m an integer
     * @return an array
     */
    public int backPackIII(int[] A, int[] V, int m) {
        // Write your code here
        if (A == null || A.length == 0 || V == null || V.length == 0) {
            return 0;
        }
        int n = A.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
            //first check the value we can get if we not use ith item
                dp[i][j] = dp[i - 1][j];
                //check whether we can put ith item into it
                if (j >= A[i - 1]) {
                //if we can put it, compare not using value, and using item value
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - A[i - 1]] + V[i - 1]);
                } 
            }
        }
        return dp[n][m];
    }
}
