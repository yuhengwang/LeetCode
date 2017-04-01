public class Solution {
    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndex(int[] A) {
        // Write your code here
        long index = 0;
        for (int i = 0; i < A.length; i++) {
            int num = 0;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[i]) {
                    num++;
                }
            }
             index += fac(A.length - i - 1) * (long)num;
        }
        return index + 1;
        
    }
    public long fac(int num) {
        long res = 1;
        for (int i = 1; i <= num; i++) {
            res = res * i;
        }
        return res;
    }
}
