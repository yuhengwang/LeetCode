How do we know string p is a permutation of string s? Easy, each character in p is in s too. So we can abstract all permutation strings
of s to a map (Character -> Count). i.e. abba -> {a:2, b:2}. Since there are only 26 lower case letters in this problem, we can just use
an array to represent the map.
How do we know string s2 contains a permutation of s1? We just need to create a sliding window with length of s1, move from beginning to 
he end of s2. When a character moves in from right of the window, we subtract 1 to that character count from the map. When a character 
moves out from left of the window, we add 1 to that character count. So once we see all zeros in the map, meaning equal numbers of every
characters between s1 and the substring in the sliding window, we know the answer is true.

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2)    return false;
        int[] count = new int[26];
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        //check whether count is all zeros
        if (checkZero(count))   return true;
        for (int i = len1; i < len2; i++) {
            count[s2.charAt(i) - 'a']--; // insert one more in right point
            count[s2.charAt(i - len1) - 'a']++; //remove one from the left
            if (checkZero(count))   return true;
        }
        return false;
    }
    public boolean checkZero(int[] count) {
        boolean f = true;
        for (int i : count) {
            if (i != 0) f = false;
        }
        return f;
    }
}



//not concise and elegant
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            alphabet[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            int[] temp = alphabet.clone();
            if (temp[s2.charAt(i) - 'a'] == 0)  continue;
            int t = i;
            while (i < s2.length() && temp[s2.charAt(i) - 'a'] != 0) {
                temp[s2.charAt(i++) - 'a']--;
            }
            boolean f = true;
            for (int a : temp) {
                if (a != 0) {
                    f = false;   
                }
            }
            if (f)  return f;
            i = t;
        }
        return false;
    }
}
