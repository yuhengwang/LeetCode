//lintcode
与Delete operation between two string的思路是一样的，int[][] count means the length of the common sequence, count[0][0] means there is no string
in string A and string B. As count[i][j] are dependent on count[i-1][j], count[i-1][j-1] and count[i][j-1]. When any of these two strings are empty,
the longest common sequence length would be 0, which is used to initialize.

public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if (A.length() == 0 || B.length() == 0 || A == null || B == null) {
            return 0;
        }
        int[][] count = new int[A.length() + 1][B.length() + 1];
        for (int i = 0; i < A.length() + 1; i++) {
            count[i][0] = 0;
        }
        for (int j = 0; j < B.length() + 1; j++) {
            count[0][j] = 0;
        }
        for (int i = 1; i < A.length() + 1; i++) {
            for (int j = 1; j < B.length() + 1; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    count[i][j] = count[i - 1][j - 1] + 1;
                } else {
                    count[i][j] = Math.max(count[i - 1][j], Math.max(count[i - 1][j - 1], count[i][j - 1]));
                }
            }
        }
        return count[A.length()][B.length()];
    }
}
