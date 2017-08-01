// find the 2-D square with one diagonal with 1 and others are 0, hence we have 3 dp array, one is to record the diagonal onlyf[i][j],
other two is to record the vertical zero and the horizontal zero.
public class Solution {
    /**
     * @param matrix a matrix of 0 and 1
     * @return an integer
     */
    public int maxSquare2(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] f = new int[m][n];
        int[][] u = new int[m][n];
        int[][] l = new int[m][n];
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    f[i][j] = 0;
                    u[i][j] = l[i][j] = 1;
                    if (i > 0)
                        u[i][j] = u[i - 1][j] + 1;
                    if (j > 0)
                        l[i][j] = l[i][j - 1] + 1;
                } else {
                    u[i][j] = l[i][j] = 0;
                    if (i > 0 && j > 0) {
                        f[i][j] = Math.min(f[i - 1][j - 1], Math.min(u[i - 1][j], l[i][j - 1])) + 1;
                    } else {
                        f[i][j] = 1;
                    }
                }
                max = Math.max(max, f[i][j]);
            }
        }
        return max * max;
    }
}
