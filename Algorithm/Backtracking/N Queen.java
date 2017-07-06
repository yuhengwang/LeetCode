public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        char[][] board = new char[n][n];
        List<String> temp = new ArrayList<>();
        dfs(res, n, 0, board);
        return res;
    }
    public boolean checkBoard(char[][] board, int i, int j) {
        for (int a = 0; a < i; a++) {
            if (board[a][j] == 'Q') {
                return false;
            }
        }
        int p = i;
        int q = j;
        while (i > 0 && j > 0) {
            if (board[--i][--j] == 'Q') {
                return false;
            }
        }
        while (p > 0 && q < board[0].length - 1) {
            if(board[--p][++q] == 'Q') {
                return false;
            }
        }
        return true;
    }
    public void dfs(List<List<String>> res, int n, int i,  char[][] board) {
        if (i == n) {
            //change board to list string and add it to res
            List<String> temp = new ArrayList<>();
            for (int a = 0; a < n; a++) {
                String t = "";
                for (int b = 0; b < n; b++) {
                    char c = board[a][b];
                    String s = c + "";
                    t += s;
                }
                temp.add(t);
            }
            res.add(new ArrayList<String>(temp));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (checkBoard(board, i, j)) {
                //update board
                for (int a = 0; a < n; a++) {
                    if (a == j) {
                        board[i][a] = 'Q';
                    } else
                        board[i][a] = '.';
                }
                dfs(res, n, i + 1, board);
            }
        }
    }
}
