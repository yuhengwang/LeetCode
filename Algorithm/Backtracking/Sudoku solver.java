// to implement sodoku, we need to ensure row, colmn and 3x3 block, the number is unique.
public class Solution {
    int m;
    int n;
// we use boolean to indicate whether one solution is valid or not
    public boolean solve(char[][] board) {
       
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {  
// we iterate inside two loop every iteration, but since we will
// change board[i][j] from . to one character, we will not operate on the same i, j on different iterations
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    // checking whether it is valid to put this number in this place
    public boolean isValid(char[][] board, int i, int j, char c) {
        for (int p = 0; p < 9; p++) {
            if (board[i][p] != '.' && board[i][p] == c) return false;
            if (board[p][j] != '.' && board[p][j] == c) return false;
            if(board[3 * (i / 3) + p / 3][ 3 * (j / 3) + p % 3] != '.' && 
                            board[3 * (i / 3) + p / 3][3 * (j / 3) + p % 3] == c) return false;
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }
        m = board.length;
        n = board[0].length;
        solve(board);
    }
}
