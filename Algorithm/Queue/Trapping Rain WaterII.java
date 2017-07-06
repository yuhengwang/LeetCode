//lc 407
//the starting point of the queue to use bfs can not only be one point, can the edge of tha matrix, iterate matrix from outer to inside
And in the class Cell, height does not mean heightMap[row][col], it records the highest height in the cell it visited.
public class Solution {
    class Cell {
        int row;
        int col;
        int height;
        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
    int m;
    int n;
    public boolean inBound(int x, int y) {
        return (x >= 0 && x < m && y >= 0 && y < n);
    }
    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length == 0 || heightMap == null || heightMap[0].length == 0 || heightMap[0] == null) 
            return 0;
        PriorityQueue<Cell> queue = new PriorityQueue<>(new Comparator<Cell>() {
            public int compare(Cell a, Cell b) {
                return a.height - b.height;
            }
        });
        m = heightMap.length;
        n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n - 1] = true;
            queue.offer(new Cell(i, 0, heightMap[i][0]));
            queue.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
        }
        for (int j = 0; j < n; j++) {
            visited[0][j] = true;
            visited[m - 1][j] = true;
            queue.offer(new Cell(0, j, heightMap[0][j]));
            queue.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
        }
        int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int res = 0;
        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            for (int[] dire : direction) {
                int newRow = cell.row + dire[0];
                int newColumn = cell.col + dire[1];
                if (!inBound(newRow, newColumn) || visited[newRow][newColumn]) {
                    continue;
                }
                visited[newRow][newColumn] = true;
                res += Math.max(0, cell.height - heightMap[newRow][newColumn]);
                queue.offer(new Cell(newRow, newColumn, Math.max(heightMap[newRow][newColumn], cell.height)));//cannot compare to heightMap[cell.row][cell.col]
                
            }
        }
            return res;
        }
    }
    
