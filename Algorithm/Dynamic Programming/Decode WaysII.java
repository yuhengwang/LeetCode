public class Solution {
    int M = 1000000007;
    public int numDecodings(String s) {
        //因为数字过大，用int会有overflow的问题
        long[] dp = new long[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '*' ? 9 : s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) == '*') {
                //* be a single character
                dp[i] = 9 * dp[i - 1];
                //十位数是1
                if (s.charAt(i - 2) == '1')
                    dp[i] = (dp[i] + 9 * dp[i - 2]) % M;
                //十位数是2
                else if (s.charAt(i - 2) == '2')
                    dp[i] = (dp[i] + 6 * dp[i - 2]) % M;
                //十位数是*，一定要是两位数，只能是11 - 19; 21 - 26, *代表1-9
                else if (s.charAt(i - 2) == '*')
                    dp[i] = (dp[i] + 15 * dp[i - 2]) % M;
            } else {
                //此位数是0时，没有信息，当做是一位数时，顺延上一位的答案
                dp[i] = s.charAt(i - 1) != '0' ? dp[i - 1] : 0;
                //十位数是1时，两位数成立
                if (s.charAt(i - 2) == '1')
                    dp[i] = (dp[i] + dp[i - 2]) % M;
                //十位数是2时，两位数成立，但是要求个位数小于等于6
                else if (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')
                    dp[i] = (dp[i] + dp[i - 2]) % M;
                //如果个位数小于等于6，那么10几，20几都成立，如果个位数大于6，只有10几才成立
                else if (s.charAt(i - 2) == '*')
                    dp[i] = (dp[i] + (s.charAt(i - 1) <= '6' ? 2 : 1) * dp[i - 2]) % M;
            }
        }
        return (int) dp[s.length()];
    }
}
