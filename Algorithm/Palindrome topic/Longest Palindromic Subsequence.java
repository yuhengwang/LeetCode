class Solution {
    public int longestPalindromeSubseq(String s) {
    //the longest length of palidrome sequence within ith and jth.
        int[][] dp = new int[s.length()][s.length()];
        for (int len = 1; len <= s.length(); len++) {
            for (int j = 0; j < s.length(); j++) {
                int i = j + len - 1;
                if (i >= s.length())    continue;
                if (len == 1) {
                    dp[j][i] = 1;
                    continue;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    dp[j][i] = (len == 2 ? 0 : len == 3 ? 1: dp[j + 1][i - 1]) + 2;
                } else {
                //!!important!!!!!!!, difference between subsequence and substring
                    dp[j][i] = Math.max(dp[j + 1][i], dp[j][i - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}
