public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    private class Coordinate {
        int x;
        int y;
        public Coordinate (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int numIslands(boolean[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int islands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]) {
                    helper(grid, i, j); // find all connect islands to caculate as 1--> make others connected parts as false
                    islands++;
                }
            }
        }
        return islands;
    }

    public void helper (boolean grid[][], int i, int j) {
        int [] directionX = {0, 1, -1, 0};
        int [] directionY = {1, 0, 0, -1};
        Queue <Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(i, j));
        grid[i][j] = false;
        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            for (int k =0; k < 4; k++) {
                Coordinate neighbor = new Coordinate(current.x + directionX[k], current.y + directionY[k]);
                if (!inBound(grid, neighbor)) {
                    continue;
                }
                if (grid[neighbor.x][neighbor.y]) {
                    grid[neighbor.x][neighbor.y] = false;
                    queue.offer(neighbor);
                }
                
            }
        }
    }
    public boolean inBound (boolean [][] grid, Coordinate coor) {
        if (coor.x >= grid.length || coor.y >= grid[0].length || coor.x < 0 || coor.y < 0) {
            return false;
        } else {
            return true;
        }
    }
}
//union find
public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
     
    class UnionFind {
        private int[] father = null;
        private int count;
        UnionFind (int n) {
            father = new int[n];
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
        }
        public int find(int x) {
            int parent = father[x];
            while (parent != father[parent]) {
                parent = father[parent];
            }
            return parent;
        }

        public void union(int x, int y) {
            int fa_x = find(x);
            int fa_y = find(y);
            if (fa_x != fa_y) {
                father[fa_x] = fa_y;
                count--;
            }
        }
        public void setCount(int count) {
            this.count = count;
        }
        public int query() {
            return count;
        }
        
    }
    public int numIslands(boolean[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int total = 0;
        UnionFind uf = new UnionFind(m * n);
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if(grid[i][j])
                    total++;
        uf.setCount(total);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]) {
                    if (i > 0 && grid[i - 1][j]) {
                        uf.union(i * n + j, (i - 1) * n + j);
                    }
                    if (i < m - 1 && grid[i + 1][j]) {
                        uf.union(i * n + j, (i + 1) * n + j);
                    }
                    if (j > 0 && grid[i][j - 1]) {
                        uf.union(i * n + j, i * n + j - 1);
                    }
                    if (j < n - 1 && grid[i][j + 1]) {
                        uf.union(i * n + j, i * n + j + 1);
                    }
                }
            }
        } 
        return uf.query();
        
    }
}
