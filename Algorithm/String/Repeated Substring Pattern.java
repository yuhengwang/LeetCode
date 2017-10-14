class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int length = s.length();
        for (int d = length / 2; d >= 1; d--) {
            String pattern = s.substring(0, d);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length / d; i++) {
                sb.append(pattern);
            }
            if (sb.toString().equals(s)) {
                return true;
            }
        }
        return false;
    }
}
