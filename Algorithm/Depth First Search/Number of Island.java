  // the order to check null situation is important!!!!!!
  public class Solution {
    int m;
    int n;
    public int numIslands(char[][] grid) {
        if (grid == null ||  grid.length == 0 || grid[0] == null || grid[0].length == 0) { //order is important!!!!!
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    public boolean inBound(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
    public void dfs(char[][] grid, int i, int j) {
        int[] dX = {-1, 0, 1, 0};
        int[] dY = {0, 1, 0, -1};
        for (int k = 0; k < 4; k++) {
            int newI = i + dX[k];
            int newJ = j + dY[k];
            if (!inBound(newI, newJ) || grid[newI][newJ] == '0') continue;
            grid[newI][newJ] = '0';
            dfs(grid, newI, newJ);
        }
    }
}
