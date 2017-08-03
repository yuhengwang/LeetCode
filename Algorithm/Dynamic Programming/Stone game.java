记忆化搜索，从大到小，先考虑最大区间 0 
public class Solution {
    /**
     * @param A an integer array
     * @return an integer
     */
    public int stoneGame(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int length = A.length;
        int[] sum = new int[length + 1];
        sum[0] = 0;
        for (int i = 1; i <= length; i++) {
            sum[i] = sum[i - 1] + A[i - 1];
        }
        //state: the value of merge from ith to jth stone
        int[][] dp = new int[length][length];
        boolean[][] visited = new boolean[length][length];
        return search(dp, visited, 0, length - 1, sum);
    }
    public int search(int[][] dp, boolean[][] visited, int i, int j, int[] sum) {
      
        if (visited[i][j]) {
            return dp[i][j];
        }
        visited[i][j] = true;
        if (i == j) {
            dp[i][j] = 0;
            return dp[i][j];
        }
      
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            min = Math.min(min, search(dp, visited, i, k, sum) + search(dp, visited, k + 1, j, sum));
        }
        dp[i][j] = min + sum[j + 1] - sum[i];
        
        return dp[i][j];
    }
