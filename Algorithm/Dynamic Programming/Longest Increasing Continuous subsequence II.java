// 记忆化搜索 用于转移状态特别麻烦和初始状态不好找的时候 
public class Solution {
    /*
     * @param : An integer matrix
     * @return: an integer
     */
    int m;
    int n;
    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        // write your code here
        if (A == null || A.length == 0 || A[0] == null || A[0].length == 0) {
            return 0;
        }
        m = A.length;
        n = A[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, search(A, dp, i, j) + 1);
            }
        }
        return max;
    }
    public boolean inBound(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
    public int search (int[][] A, int[][] dp, int i, int j) {
        if (dp[i][j] != 0) {
            return dp[i][j]; //记忆化搜索
        }
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        int ans = 0;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (!inBound(x, y)) continue;
            if (A[x][y] < A[i][j]) {
                ans = Math.max(ans, search(A, dp, x, y) + 1);
            }
        }
        dp[i][j] = ans;
        return dp[i][j];
    }
};
