time complexity O(m * n)
space complexity O(2 * n), when dp line i only depend on i - 1, we can use corresponding % to decrease the space complexity
public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        //state: how many bian chang be connected when matrix[i][j] is the right down corner of the square
        int[][] f = new int[2][n + 1];
        //initialization
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1')
                    f[i % 2][j] = Math.min(Math.min(f[(i - 1) % 2][j], f[(i - 1) % 2][j - 1]), f[i % 2][j - 1]) + 1;
                else
                    f[i % 2][j] = 0;
               // System.out.println(i + " " + j + " " + f[i][j]);
                max = Math.max(max, f[i % 2][j]);
            }
        }
        return max * max;
    }
}



//DP matrix has reserved two more initialization sometimes can make program shorter
time complexity: O(m * n)
space compelxity : O(m * n)
public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        //state: how many bian chang how be connected when matrix[i][j] is the right down corner of the square
        int[][] f = new int[m + 1][n + 1];
        //initialization 
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1')
                    f[i][j] = Math.min(Math.min(f[i - 1][j], f[i - 1][j - 1]), f[i][j - 1]) + 1;
                else
                    f[i][j] = 0;
               // System.out.println(i + " " + j + " " + f[i][j]);
                max = Math.max(max, f[i][j]);
            }
        }
        return max * max;
    }
}



public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        //state: how many bian chang how be connected when matrix[i][j] is the right down corner of the square
        int[][] f = new int[m][n];
        //initialization
        for (int i = 0; i < m; i++) {
            f[i][0] = matrix[i][0] - 48; // int and char conversion
            max = Math.max(f[i][0], max);
        }
        for (int j = 0; j < n; j++) {
            f[0][j] = matrix[0][j] - 48;
            max = Math.max(f[0][j], max);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1')
                    f[i][j] = Math.min(Math.min(f[i - 1][j], f[i - 1][j - 1]), f[i][j - 1]) + 1;
                else
                    f[i][j] = 0;
               // System.out.println(i + " " + j + " " + f[i][j]);
                max = Math.max(max, f[i][j]);
            }
        }
        return max * max;
    }
}
