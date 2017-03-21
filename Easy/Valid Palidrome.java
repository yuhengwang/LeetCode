public class Solution {
    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // Write your code here
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char c1 = s.charAt(i);
            while (i < s.length() - 1 && !((c1 >= 'a' && c1 <= 'z' )|| (c1 >= 'A' && c1 <= 'Z')
                        || (c1 >= '0' && c1 <= '9'))) {
                i++;
                c1 = s.charAt(i);
            }
            char c2 = s.charAt(j);
    //        System.out.println(c2);
           
            while (j > 0 && !((c2 >= 'a' && c2 <= 'z') || (c2 >= 'A' && c2 <= 'Z') 
                        || (c2 >= '0' && c2 <= '9'))) {
                j--;
       //         System.out.println(j);
                c2 = s.charAt(j);
            }
         //   System.out.println(i + "\t" + j);
            if (j == 0 && i == s.length() - 1) {
                return true;
            }
            if (c1 != c2 && Math.abs(c1 - c2) != 32) {
                return false;
            }
            i++;
            j--;
            
        }
        return true;
    }
}
