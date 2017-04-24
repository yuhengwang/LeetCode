public class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0) {
            return -1;
        }
        if (grid[0] == null || grid[0].length == 0) {
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        // state: as the minimum path from top left to m, n
        int[][] f = new int[m][n];
        //initialize
        f[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            f[0][i] = f[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            f[i][0] = f[i - 1][0] + grid[i][0];
        }
        //loop
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j];
            }
        }
        return f[m - 1][n - 1];
    }
}
