public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here
        if (A == null || A.length == 0 || V == null || V.length == 0) {
            return 0;
        }
        int n = A.length;
        //state: the maximum value that the first ith object can achieve under the amount constraints
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j - A[i - 1]] + V[i - 1], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
        
    }
}
