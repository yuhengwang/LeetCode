time complexity O(n), space O(1)
public class Solution {
    public int longestValidParentheses(String s) {
        //left right, two pointer
        int left = 0, right = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') left++;
            else right++;
            if (left == right) {
                max = Math.max(max, 2 * left);
            }
            if (right > left) {
                right = 0;
                left = 0;
            }
        }
        left = 0;
        right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') right++;
            else left++;
            if (left == right) {
                max = Math.max(max, 2 * right);
            }
            if (left > right) {
                right = 0;
                left = 0;
            }
        }
        return max;
    }
}



//how long the length of valid parenthese ends at index i
public class Solution {
    public int longestValidParentheses(String s) {
        //dp
        int max = 0;
        int[] dp = new int[s.length() + 1];
        for (int i = 2; i < s.length() + 1; i++) {
        //()
            if (s.charAt(i - 1) == ')' && s.charAt(i - 2) == '(') {
                dp[i] = dp[i - 2]+ 2;
            }
        //()(())
        The reason behind this is that if the 2nd last ‘)’’ was a part of a valid substring (say subs)
 for the last ‘)’ to be a part of a larger substring, there must be a corresponding starting ‘(’ which lies before the 
 valid substring of which the 2nd last ‘)’ is a part. Thus, if the character before subs happens to be ‘(’, we update the dp[i] as an addition of 2
 in the length of subs, which is dp[i−1]. To this, we also add the length of the valid substring just before the term "(,sub_s,)" ,
 i.e. dp[i−dp[i−1]−2]
 
 
            if (s.charAt(i - 1) == ')' && s.charAt(i - 2) == ')') {
                if (i - dp[i - 1] >= 2 && s.charAt(i - dp[i - 1] - 2) == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
