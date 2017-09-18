class Solution {
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
            //delete start or delete end
                return isPalindrome(s.substring(start + 1, end + 1)) || isPalindrome(s.substring(start, end));
            }
            start++;
            end--;
        }
        return true;
    }
    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
 }
