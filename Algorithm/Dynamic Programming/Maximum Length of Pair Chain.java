//longest increasing sequence 变种
经典loop
 for (int i = 1; i < nums.length; i++) {
      
            for (int j = 0; j < i; j++) {
            
            }
         
        }
        

class Solution {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0 || pairs[0] == null || pairs[0].length == 0) {
            return 0;
        }
        Arrays.sort(pairs, (a, b)->(a[0] - b[0]));
        int m = pairs.length;
        int n = pairs[0].length;
        int[] dp = new int[m + 1];
        Arrays.fill(dp, 1);
        dp[0] = 0;
        for (int i = 2; i <= m; i++) {
            int curLen = 1;
            for (int j = 1; j < i; j++) {
                if (pairs[j - 1][1] < pairs[i - 1][0]) {
                    curLen = Math.max(dp[j] + 1, curLen);
                }
            }
            dp[i] = Math.max(dp[i], curLen);
        }
        return dp[m];
    }
}
