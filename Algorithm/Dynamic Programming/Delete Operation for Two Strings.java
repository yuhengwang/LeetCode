//leetcode 583
similar to longest common subsequence. int[i][j] dp is used to caculate the distance for the first i character in word1 and the first j cha
racters in word2. when i = 0 or j = 0, means there is no character in word1 or word2. And the distance should be the length of another word.
because we need to delete all the other words to get the same pair. then we start to test whether the two characters are same on some indexes, if
the characters are same, meanining we do not change for this additional move, which means dp[i][j] = dp[i- 1][j-1], if the two characters are different,
we need to consider three solutions from possible last step, which is dp[i-1][j-1],dp[i-1][j],dp[i][j-1].
public class Solution {
    //use dp
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < word2.length() + 1; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1] + 1, Math.min(dp[i - 1][j - 1] + 2, dp[i - 1][j] + 1));
                
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
