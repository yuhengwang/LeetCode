//bottom up
public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        int m = triangle.length;
       
        // record the minimum path sum from point i, j to the last layer
        int[][] f = new int[m][m];
        //initialization 
        for (int i = 0; i < m; i++) {
            f[m - 1][i] = triangle[m - 1][i];
        }
        //loop
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                f[i][j] = Math.min(f[i + 1][j], f[i + 1][j + 1]) + triangle[i][j];
            }
        }
        return f[0][0];
        
    }
}
