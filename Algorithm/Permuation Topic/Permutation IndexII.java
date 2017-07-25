// when there is repeated number in the integer array, the only different part is to remove the replicated caculation, that is to find 
// the number of repetition and divide the number from index caculated, 4 2 1 1, so we will divide 2! from the index. if 4 1 1 1, so we will
// divide 3!.
public class Solution {
    /**
     * @param A an integer array
    https://www.lintcode.com/en/problem/permutation-index-ii/#testcase * @return a long integer
     */
    public long permutationIndexII(int[] A) {
        // Write your code here
        long res = 0;
        for (int i = 0; i < A.length; i++) {
            int num = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(A[i], 1);
            for (int j = i + 1; j < A.length; j++) {
                if (map.containsKey(A[j])) {
                        map.put(A[j], map.get(A[j]) + 1);
                } else {
                        map.put(A[j], 1);
                } 
                if (A[j] < A[i]) {
                     num++;
                }
            }
            long temp = fac(A.length - i - 1) * num;
            for (int value : map.values()) {
                temp /= fac(value);
            }
            res += temp;
        }
        return res + 1;
    }
    public long fac(int num) {
        long res = 1;
        for (int i = 1; i <= num; i++) {
            res = res * i;
        }
        return res;
    }
}
