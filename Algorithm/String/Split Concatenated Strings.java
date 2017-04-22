// leetcode 555
find the max character in the string and for each string element in the array, compare it with its reverse string, and keep the 
lexicographically bigger one. 
The cut point of the string can only happen before the lexicographically largest character. and we should consider when the element in the
array strs non-reverse situation, and compare the result with the current biggest one. When we test it is better to be reverse or not,
we need to ensure other elements in the array has the biggest status. 

public class Solution {
    public String splitLoopedString(String[] strs) {
        char max = 'a';
        for (int i = 0; i < strs.length; i++) {
            for (char c : strs[i].toCharArray()) {
                if (c > max) max = c;
            }
            String rev = new StringBuilder(strs[i]).reverse().toString();
            if (rev.compareTo(strs[i]) > 0) strs[i] = rev;
            
        }
        String res = "";
        for (int i = 0; i < strs.length; i++) {
            String rev = new StringBuilder(strs[i]).reverse().toString();
            for (String st : new String[]{strs[i], rev}) {
                for (int j = 0; j < st.length(); j++) {
                    if (st.charAt(j) != max) {
                        continue;
                    }
                    StringBuilder sb = new StringBuilder(st.substring(j));
                    for (int k = i + 1; k < strs.length; k++) {
                        sb.append(strs[k]);
                    }
                    for (int k = 0; k < i; k++) {
                        sb.append(strs[k]);
                    }
                    sb.append(st.substring(0, j));
                    if (sb.toString().compareTo(res) > 0) {
                        res = sb.toString();
                    }
                    
                }    
            }
            
        }
        return res;
        
    }
}
