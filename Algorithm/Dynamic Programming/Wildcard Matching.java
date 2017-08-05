public class Solution {
    public boolean isMatch(String s, String p) {
        //state: String s ends at ith character, String p ends at jth character, whether match or not
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        match[0][0] = true;
        //if the pattern starts with ****, it will always match s ends at position 0
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i - 1) != '*') {
                break;
            }
            match[0][i] = true;
        }
        //a
        //*
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    match[i][j] = match[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                //match[i - 1][j] consider * as some sequence, if it works without ith element, it will 
                //also work out with ith element, match[i][j - 1] treats * as empty string
                    match[i][j] = match[i - 1][j] || match[i][j - 1];
                } else {
                    match[i][j] = false;
                }
            }
        }
        return match[s.length()][p.length()];
    }
}
