Given a string, determine if a permutation of the string could form a palindrome.

For example,
"code" -> False, "aab" -> True, "carerac" -> True. 


time complexity: O(n)
space complexity: O(1)
public class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null) {
            return false;
        }
        int count = 0;
        //ASCII code has 128
        for (int i = 0; i < 128 && count <= 1; i++) {
            int cnt = 0;
            for (int j = 0; j < s.length(); j++) {
                if ((int)s.charAt(j) == i) {
                    cnt++;
                }
            }
            count += cnt % 2;
        }
        return count <= 1;
    }
}

//use HashMap, we can also use array and set to solve this problem, please note getOrDefault method, is convenient and concise!
time complexity: O(N)
space complexity: o(N)
public class Solution {
    public boolean canPermutePalindrome(String s) {
     HashMap < Character, Integer > map = new HashMap<>();
     for (int i = 0; i < s.length(); i++) {
         map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
     }
     int count = 0;
     for (int v: map.values()) {
         count += v % 2;
     }
     return count <= 1;

    }
}
