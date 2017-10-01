(i + j) % k is very important, we will mimic rotate the string, because this repeatedstring will work, B need to contains the permutation
of String A.
class Solution {
    public int repeatedStringMatch(String A, String B) {
        for (int i = 0; i < A.length(); i++) {
            int b0 = 0;
            for (int j = 0; j < B.length(); j++) {
                int k = (i + j) % A.length();
                if (A.charAt(k) != B.charAt(j)) {
                    b0 = 1;
                    break;
                }
            }
            // which means we find the exact match starting at ith num of string A, so we need to add first i for the repeated A to contains
            String B, but it is better for us to minus 1!!!. 
            if (b0 == 0) {
                int num = (i + B.length() - 1) / A.length() + 1;
                return num;
            }
        }
        return -1;
    }
}
