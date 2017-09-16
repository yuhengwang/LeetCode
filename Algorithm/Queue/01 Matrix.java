class Solution {
    int m;
    int n;
    int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return new int[][]{};
        }
        m = matrix.length;
        n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = bfs(matrix, i, j);
                }
            }
        }
        return matrix;
    }
    public boolean inBound(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
    public int bfs(int[][] matrix, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            for (int s = 0; s < size; s++) {
                int[] p = queue.poll();
                for (int[] d : delta) {
                    int x = p[0] + d[0];
                    int y = p[1] + d[1];
                    if (!inBound(x, y)) continue;
                    if (matrix[x][y] == 0)  return distance;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return -1;
    }
}
