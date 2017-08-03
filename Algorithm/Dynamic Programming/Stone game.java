记忆化搜索，从大到小，先考虑最大区间 0 - n - 1的融合情况
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
        //找到造成价值最小的分割点， k，当k等于i时，第一个不被融合，当k等于j  -1时最后一位不被融合
        for (int k = i; k < j; k++) {
            min = Math.min(min, search(dp, visited, i, k, sum) + search(dp, visited, k + 1, j, sum));
        }
        dp[i][j] = min + sum[j + 1] - sum[i]; //ith 到jth的元素之和
        
        return dp[i][j];
    }
