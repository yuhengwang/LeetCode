public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
    public int kSum(int A[], int k, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        //select j numbers from the first ith numbers to achieve amount k
        int[][][] f = new int[n + 1][k + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            f[i][0][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                for (int q = 1; q <= target; q++) {
                    if (q >= A[i - 1])
                    //add "we do not use ith item" + "we use ith item"
                    f[i][j][q] = f[i - 1][j][q] + f[i - 1][j - 1][q - A[i - 1]];
                    else
                    //we cannot use ith item
                    f[i][j][q] = f[i - 1][j][q];
                }
            }
            
        }
        return f[n][k][target];
    }
}
