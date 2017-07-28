//Two Queue and add all the Pacific border to one queue; Atlantic border to another queue.
2.Keep a visited matrix for each queue. In the end, add the cell visited by two queue to the result.
 BFS: Water flood from ocean to the cell. Since water can only flow from high/equal cell to low cell, add the neighboor cell with height larger or equal to current cell to the queue and mark as visited
time complexity: O(MN), in the worst case, we need to visit every cell in the ocean
public class Solution {
    int m;
    int n;
    int[][] dir = new int[][]{{-1, 0},{1, 0}, {0, 1}, {0, -1}};
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return res;
        }
        m = matrix.length;
        n = matrix[0].length;
        Queue<int[]> pacificQ = new LinkedList<>();
        Queue<int[]> atlanticQ = new LinkedList<>();
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        //add the border to queue and visited map
        //vertical border
        for (int i = 0; i < m; i++) {
            pacificQ.offer(new int[]{i, 0});
            atlanticQ.offer(new int[]{i, n - 1});
            pacific[i][0] = true;
            atlantic[i][n - 1] = true;
        }
        //horizontal border
        for (int i = 0; i < n; i++) {
            pacificQ.offer(new int[]{0, i});
            atlanticQ.offer(new int[]{m - 1, i});
            pacific[0][i] = true;
            atlantic[m - 1][i] = true;
        }
        bfs(pacific, pacificQ, matrix);
        bfs(atlantic, atlanticQ, matrix);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j])
                    res.add(new int[]{i, j});
            }
        }
        return res;
    }
    public void bfs(boolean[][] visited, Queue<int[]> queue, int[][] mask) {
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] d: dir) {
                    int x = curr[0] + d[0];
                    int y = curr[1] + d[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || mask[curr[0]][curr[1]] > mask[x][y]) continue;
                    visited[x][y] = true;
                    queue.offer(new int[]{x, y});
                }
            }
        }
    }
}
