//leetcode 564
My solution is based on ....
We first need to find the higher palindrome and lower palidrome respectively. and return the one who has the least different with the input number.

For the higher palindrome, the low limit is number + 1 while for the lower palindrome, the high limit is number - 1.

One global solution is to find a palindrome is to copy first half part of the array to the last half part, we regards this as standard palindrome.
We need to detect this standard palindrome belongs to higher one or the lower one. And other solutions will be based on this standard one. 

For the higher palindrome, if the standard one belongs to higher, we just simply return it. Or we need to change it.
For example, String n is 1343, and the standard palindrome is 1331. to get the higher one from the standard palidrome, we start from the 
first 3, which is (n.length - 1) / 2. Add the number by 1, (---> 1431)if the added result is not higher than 9, the changing process is finished,
otherwise, continuously changing the number of previous index by i. After the changing process, we re-palidrome the string. (1431 -- > 1441)

For the lower palindrome, similar idea.But we need to notice that when we decrease a number, and if the first character of the string is '0',
we need to resize the array of n.length - 1, and fill in with '9'. (for example, n is '1000', the standard palidrome is '1001'(higher one),
the lower one '0000'-->'999'.)


public class Solution {
    public String nearestPalindromic(String n) {
        Long number = Long.parseLong(n);
        Long big = findHigherPalindrome(number + 1);
        Long small = findLowerPalindrome(number - 1);
        return Math.abs(number - small) > Math.abs(big - number) ? String.valueOf(big) : String.valueOf(small);
    }
    public Long findHigherPalindrome(Long limit) {
        String n = Long.toString(limit);
        char[] s = n.toCharArray(); // limit
        int m = s.length;
        char[] t = Arrays.copyOf(s, m); // target
        for (int i = 0; i < m / 2; i++) {
            t[m - 1 - i] = t[i];
        }
        for (int i = 0; i < m; i++) {
            if (s[i] < t[i]) {
                return Long.parseLong(String.valueOf(t)); 
            } else if (s[i] > t[i]) { // need to be changed
                for (int j = (m - 1) / 2; j >= 0; j--) {
                    if (++t[j] > '9') {
                        t[j] = '0';
                    } else {
                        break;
                    }
                }
                // make it palindrome again
                for (int k = 0; k < m / 2; k++) {
                    t[m - 1 - k] = t[k];
                }
                return Long.parseLong(String.valueOf(t)); 
            }
        }
        return Long.parseLong(String.valueOf(t));    
    }
    public Long findLowerPalindrome(Long limit) {
        String n = Long.toString(limit);
        char[] s = n.toCharArray();
        int m = s.length;
        char[] t = Arrays.copyOf(s, m);
        for (int i = 0; i < m / 2; i++) {
            t[m - 1 - i] = t[i];
        }
        for (int i = 0; i < m; i++) {
            if (s[i] > t[i]) {
                return Long.parseLong(String.valueOf(t)); 
            } else if (s[i] < t[i]) {
                for (int j = (m - 1) / 2; j >= 0; j--) {
                    if (--t[j] < '0') {
                        t[j] = '9';
                    } else {
                        break;
                    }
                }
                if (t[0] == '0') {
                    char[] a = new char[m - 1];
                    Arrays.fill(a, '9');
                    return Long.parseLong(String.valueOf(a)); 
                }
                // make it palindrome again
                for (int k = 0; k < m / 2; k++) {
                    t[m - 1 - k] = t[k];
                }
                return Long.parseLong(String.valueOf(t)); 
            }
        }
         return Long.parseLong(String.valueOf(t));  
    }
}
