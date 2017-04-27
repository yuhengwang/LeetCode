// loop from up to down first and from left to right second, 
public class Solution {
    /**
     * @param grid a chessboard included 0 and 1
     * @return the shortest path
     * [[0,0,0,0],
        [0,0,0,0],
        [0,0,0,0]]

     */
    int m;
    int n;
    int[] deltaY = {-1, -1, -2, -2};
    int[] deltaX = {-2, 2, -1, 1};
    public int shortestPath2(boolean[][] grid) {
        // Write your code here
        m = grid.length;
        n = grid[0].length;
        //path to record shortnest steps to get here
        int[][] path = new int[m][n];
        for (int i = 0; i < path.length; i++) {
            Arrays.fill(path[i], Integer.MAX_VALUE);
        }
        path[0][0] = 0;
        //loop order is important, loop from up to down first and from left to right second
        for (int j = 0; j < n; j++) {   //!!!!!!!!!
            for (int i = 0; i < m; i++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (grid[i][j]) {
                    continue;
                }
               check(i, j, path, grid);
            }
        }
      
        return path[m - 1][n - 1] == Integer.MAX_VALUE ? -1 : path[m - 1][n - 1];
    }
    public void check(int i, int j, int[][] path, boolean[][] grid) {
        //check for 4 directions
        for (int k = 0; k < 4; k++) {
            int x = i + deltaX[k];
            int y = j + deltaY[k];
            if (!inBound(x, y) || grid[x][y] || path[x][y] == Integer.MAX_VALUE) {
                continue;
            }
            path[i][j] = Math.min(path[x][y] + 1, path[i][j]);
        }
    }
    public boolean inBound(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
