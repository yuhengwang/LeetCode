class Solution {
    public String longestPalindrome(String s) {
       boolean[][] dp = new boolean[s.length()][s.length()];
       String res = null;
        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i < s.length(); i++) {
                int j = i + len - 1;
                if (j >= s.length())    continue;
                dp[i][j] = s.charAt(i) == s.charAt(j) && (len <= 3 || dp[i + 1][j - 1]);
                if (dp[i][j] && (res == null || len > res.length()))
                    res = s.substring(i, i + len);
            }
        }
        return res;

    }
}
