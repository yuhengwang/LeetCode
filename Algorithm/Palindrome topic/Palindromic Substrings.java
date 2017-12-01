class Solution {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length() + 1][s.length() + 1];
        int count = 0;
        for (int i = 1; i < s.length() + 1; i++) {
            dp[i][i] = true;
            count++;
        }
        dp[0][0] = true;
        for (int i = 2; i < s.length() + 1; i++) {
            for (int j = 1; j < i; j++) {
                if (i == j) continue;
                dp[j][i] = (j + 1 <= i - 1 ? dp[j + 1][i - 1] : true) && s.charAt(j - 1) == s.charAt(i - 1);
                if (dp[j][i]) {
                    count++;
                }
            }
        }
        return count;
    }
}
