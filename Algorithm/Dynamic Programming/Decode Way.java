public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        //the number of decode ways ends at ith postion of string s
        int[] f = new int[s.length() + 1];
        f[0] = 1;
        f[1] = s.charAt(0) == '0' ? 0 : 1;
        //12
        for (int i = 2; i <= s.length(); i++) {
            int first = Integer.parseInt(s.substring(i - 1, i));
            int second = Integer.parseInt(s.substring(i - 2, i));
            if (first <= 9 && first > 0) {
                f[i] += f[i - 1];
            }
            if (second >= 10 && second <= 26) {
                f[i] += f[i - 2];
            }
        }
        return f[s.length()];
    }
}
