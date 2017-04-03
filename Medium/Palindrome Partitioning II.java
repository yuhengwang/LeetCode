public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    public boolean[][] getIsPalindrome(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            isPalindrome[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
       
        for (int length = 2; length < s.length(); length++) {
            for (int i = 0; i + length < s.length(); i++) {
                isPalindrome[i][i + length] = isPalindrome[i + 1][i + length - 1] && 
                                                s.charAt(i) == s.charAt(i + length);
            }
            
        }
        return isPalindrome;
    }
    public int minCut(String s) {
        // write your code here
        boolean[][] isPalindrome = getIsPalindrome(s);
        int[] f = new int[s.length() + 1];
        f[0] = 0;
        for (int i = 1; i < s.length() + 1; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j][i - 1]) {
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }
        return f[s.length()] - 1;
    }
};
