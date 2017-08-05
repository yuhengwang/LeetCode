public class Solution {
    public boolean isMatch(String s, String p) {
        //state : String s stop at ith character, String p stop at jth character, whether they match or not
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        match[0][0] = true;
        //if the pattern is like a*c*b*, it will always match the string s ends at position 0, note that * will not start at the 0th postion
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && match[0][i - 1]) {
                match[0][i + 1] = true;
            }
        }
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < p.length() + 1; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    match[i][j] = match[i - 1][j - 1];
                
                } else if (p.charAt(j - 1) == '*') {
                //aaa
                //a*
                //this situation, we treat * as multiple a, match[i - 1][j]
                // if there are multiple same letters, it is still counting from first repeated to last, 
                //so the first time when we see * and the first repeated letter, we will use as single letter case, 
                //and next when we see the second letter, we will simple check if there previous is single letter case and 
                //if that is true. if the single letter matches *, it means the second is also true. And if we check the third, 
                //forth and so on it just need to take the previous results.
                
                // we treat * as single a, match[i][j - 1], it means * has no use
                // we treat * as empty string, match[i][j - 2], it means * and the previous character has no use
                    if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') 
                        match[i][j] = match[i][j - 1] || match[i][j - 2] || match[i - 1][j];
                    else 
                        match[i][j] = match[i][j - 2];
                } 
            }
        }
        return match[s.length()][p.length()];
    }
}
