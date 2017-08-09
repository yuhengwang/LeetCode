//判定条件用substring转换成数字来判断，要简单许多
public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        //the number of decode ways for the string starts at ith position
        int[] f = new int[s.length() + 1];
        int n = s.length();
        f[n] = 1;
        // if the character is 0, it contains no information
        f[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;
        
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') continue;
            if (Integer.parseInt(s.substring(i, i + 2)) <= 26) {
                f[i] = f[i + 1] + f[i + 2];
            } else {
                f[i] = f[i + 1];
            }
        }
        return f[0];
    }
}


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
