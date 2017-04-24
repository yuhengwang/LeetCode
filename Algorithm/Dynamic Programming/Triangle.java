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
//top down
public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        if (triangle == null || triangle.length == 0) {
            return -1;
        }
        if (triangle[0] == null || triangle[0].length == 0) {
            return -1;
        }
        int m = triangle.length;
       
        // state: f[x][y] = minimum path value from 0,0 to x,y
        int[][] f = new int[m][m];
        //initialization left and right side, and the top
        f[0][0] = triangle[0][0];
        for (int i = 1; i < m; i++) {
            f[i][0] = f[i - 1][0] + triangle[i][0];
            f[i][i] = f[i - 1][i - 1] + triangle[i][i];
        }
        //loop
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < i; j++) {
                f[i][j] = Math.min(f[i - 1][j], f[i - 1][j - 1]) + triangle[i][j];
            }
        }
        int best = f[m - 1][0];
       // System.out.println(best);
        for (int i = 1; i < m; i++) {
            best = Math.min(best, f[m - 1][i]);
        }
        return best;
     
    
    }
}
