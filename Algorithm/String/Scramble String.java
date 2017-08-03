public class Solution {
    public boolean isScramble(String s1, String s2) {  
        if (s1.equals(s2)) {
            return true;
        }
        int[] letter = new int[127];
        for (int i = 0; i < s1.length(); i++) {
            letter[s1.charAt(i) - 'a']++;
            letter[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 127; i++) {
            if (letter[i] != 0) { 
                return false;
            }
        }
        //i needs to start from 1
        for (int i = 1; i < s1.length(); i++) {
        //if the normal order is correct
            if (isScramble(s1.substring(0,i), s2.substring(0,i)) 
             && isScramble(s1.substring(i), s2.substring(i))) return true;
        //if the normal order is not correct, the order may be reversed in the parent node
            if (isScramble(s1.substring(0,i), s2.substring(s2.length()-i)) 
             && isScramble(s1.substring(i), s2.substring(0,s2.length()-i))) return true;
        }
        return false;
    }
}
