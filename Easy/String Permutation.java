public class Solution {
    /**
     * @param A a string
     * @param B a string
     * @return a boolean
     */
    public boolean stringPermutation(String A, String B) {
        // Write your code here
       int[] cnt = new int[1000];
       for (int i = 0; i < A.length(); i++) {
           cnt[(int)A.charAt(i)]++;
       }
       for (int j = 0; j < B.length(); j++) {
           cnt[(int)B.charAt(j)]--;
       }
       for (int i = 0; i < 1000; i++) {
           if (cnt[i] != 0) {
               return false;
           }
       }
       return true;
}
}
