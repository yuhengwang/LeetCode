// the order of the character is important, hence we cannot use char array to record each character appear times,instead we need to 分类讨论
public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        for (int i = 0; i < Math.min(m, n); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (m == n) {
                    return s.substring(i + 1).equals(t.substring(i + 1));  // replace
                } else if (m > n) {
                    return s.substring(i + 1).equals(t.substring(i)); //delete s.charAt(i)
                } else {
                    return s.substring(i).equals(t.substring(i + 1)); //delete t.charAt(i)
                }
                
            }
        }
        return Math.abs(m - n) == 1; //meaning the elements before are all same. 
        //delete the last element, make sure the length difference is 1
    }
}
