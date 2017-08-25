Chracter.isLetter(), isLetterOrDigit()
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            while (i < s.length() && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while (j >= 0 && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if (i >= s.length() && j < 0)   return true;
            if (i >= s.length() && j >= 0)  return false;
            if (i < s.length() && j < 0)    return false;
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
}
