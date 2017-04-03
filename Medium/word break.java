public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        int maxLength = maxLength(dict);
        boolean[] possible = new boolean[s.length() + 1];
        possible[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= maxLength&& j <= i ; j++) {
                if (!possible[i - j]) {
                    continue;
                }
                if (dict.contains(s.substring(i - j, i))) {
                    possible[i] = true;
                    break;
                }
            }
        }
        return possible[s.length()];
  
      
    }
    public int maxLength(Set<String> dict) {
        int length = -1;
        for (String s: dict) {
            length = Math.max(length, s.length());
        }
        return length;
    }
}
