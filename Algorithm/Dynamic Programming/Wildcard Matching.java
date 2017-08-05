//optimal solution
public class Solution {
    public boolean isMatch(String s, String p) {
        int sIndex = 0;
        int pIndex = 0;
        int start = -1;
        int match = 0;
        //abcc
        //a*c
        while (sIndex < s.length()) {
            if (pIndex < p.length() && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?')) {
                pIndex++;
                sIndex++;
            } else if (pIndex < p.length() && p.charAt(pIndex) == '*') {
                start = pIndex;
                match = sIndex;
                pIndex++;
// * continuously represent any character in String s, if like abcc, a*c, if program jump out * representation at the first c, it will not //be corrrect. When pIndex reach the end, it will not satisfy the above two conditions, and enter start != -1, to retrieve the previous //state when representation just happened, and make representation represents one more character
            } else if (start != -1) {
                pIndex = start + 1;
                match++;
                sIndex = match;
            } else {
                return false;
            }
        }
    
        while (pIndex < p.length() && p.charAt(pIndex) == '*') {
            pIndex++;
        }
        return pIndex == p.length();
    }
}




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
