// has to be inplace
we use the the first row and the first column as the indicator each row and each column, 
but since the first row and first column are same on (0,0), we use another indicator especially for col0.
!!!!!
NOTICE:
when we assign 0s, we need to bottom up, indicator has to be updated at the last!!!!!
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int col = 1;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0)  col = 0;
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col == 0)   matrix[i][0] = 0;
        }
        
    }
}

