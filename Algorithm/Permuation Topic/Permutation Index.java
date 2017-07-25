When there is NO repeated number in the int array
// if a number in 95423
// for the first position, we can find there are 4 numbers smaller than 9, so these 4 numbers: 5, 4, 2, 3 can be the first position before,
// and all other combination should be 4! for each number, so before this integer sequence, we have 4 * 4!. When we secure that the first position is 9,
// Then we check the last 4 numbers, for the second position 4, 2, 3 can be also possible, and each number has 3! combinations, we have 3 * 3!....
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
                    num++;   // change how many numbers is larger than the threshold
                }
            }
             index += fac(A.length - i - 1) * (long)num;// possible numbers times n!
        }
        return index + 1; // the index is counted starting from 1
        
    }
    public long fac(int num) {
        long res = 1;
        for (int i = 1; i <= num; i++) {
            res = res * i;
        }
        return res;
    }
}
