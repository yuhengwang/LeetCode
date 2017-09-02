space complexity is O(1)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return res;
        }
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            //traverse right
            for (int j = colBegin; j <= colEnd; j++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;
            //traverse down
            for (int i = rowBegin; i <= rowEnd; i++) {
                res.add(matrix[i][colEnd]);
            }
            colEnd--;
            
            we have to check rowBegin and rowEnd condition, some matrix is not square
            if (rowBegin <= rowEnd) {
            //traverse left
                for (int j = colEnd; j >= colBegin; j--) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;
             we have to check colBegin and colEnd condition
            if (colBegin <= colEnd) {
            //traverse up
                for (int i = rowEnd; i >= rowBegin; i--) {
                    res.add(matrix[i][colBegin]);
                }
            }
            colBegin++;  
        }
        return res;
    }
}



space complexity is a little high
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        //right, down, left, up
        int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int i = 0;
        int j = 0;
        res.add(matrix[i][j]);
        visited[i][j] = true;
        int count = 1;
        while (true && count < m * n) {
            for (int[] dir : d) {
                int dx = i + dir[0];
                int dy = j + dir[1];
                while (inBound(dx, dy, m, n) && !visited[dx][dy]) {
                 //   System.out.println(matrix[dx][dy]);
                    res.add(matrix[dx][dy]);
                    visited[dx][dy] = true;
                    dx = dx + dir[0];
                    dy = dy + dir[1];
                    count++;
                }
                i = dx - dir[0];
                j = dy - dir[1];
            }
        }
        return res;
    }
    public boolean inBound(int dx, int dy, int m, int n) {
        return dx >= 0 && dy >= 0 && dx < m && dy < n;
    }
}
