 // no additional space, we dont need the boolean array to track the path, but encrypted every cell we visited.
public class Solution {
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, 0, i, j)) {
                   return true;
                }
            }
        }
        return false;
    }
    public boolean inBound(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
    public boolean dfs(char[][] board, String word, int index, int i, int j) {
        if (index == word.length()) {
            return true;
        }
        if (!inBound(i, j) || board[i][j] != word.charAt(index)) {
            return false;
        }
        board[i][j] ^= 256; //encryption
        boolean res = dfs(board, word, index + 1, i + 1, j) || dfs(board, word, index + 1, i, j + 1) ||
            dfs(board, word, index + 1, i - 1, j) || dfs(board, word, index + 1, i, j - 1);
        board[i][j] ^= 256; //decryption
        return res;
    }
}


// to avoid TLE, insteaad of using a global boolean variable and the four directions to have a loop in dfs function, we 
// change the return type of dfs function to boolean
public class Solution {
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, visited, word, 0, i, j)) {
                   return true;
                }
            }
        }
        return false;
    }
    public boolean inBound(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
    public boolean dfs(char[][] board, boolean[][] visited, String word, int index, int i, int j) {
        if (index == word.length()) {
            return true;
        }
        if (!inBound(i, j) || board[i][j] != word.charAt(index) || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        boolean res = dfs(board, visited, word, index + 1, i + 1, j) || dfs(board, visited, word, index + 1, i, j + 1) ||
            dfs(board, visited, word, index + 1, i - 1, j) || dfs(board, visited, word, index + 1, i, j - 1);
        visited[i][j] = false;
        return res;
    }
}
