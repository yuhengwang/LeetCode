//leetcode 289
because this question need to be manipulate in place. hence the use the last bit as the current state, and the second last bit as the next state.
The initial state is 00 and 01
00---> 10  dead --> live
01 ---> 11 live ---> live 
there are the only two transition we need to handle.
To get the current state, we use & 1 to extract the last bit
To get the next state, we use >> 1 to extract the second last bit
public class Solution {
    int[] deltaX = {-1, 0, 0, 1, -1, -1, 1, 1};
    int[] deltaY = {0, 1, -1, 0, 1, -1, 1, -1};
    int m;
    int n;
    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int live = live(i, j, board);
                if (board[i][j] == 1 && (live == 2 || live ==3)) {
                    board[i][j] = 3;
                }
                if (board[i][j] == 0 && live == 3) {
                    board[i][j] = 2;
                }
                
            }
        }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) 
                board[i][j] >>= 1;
        
    }
    public int live(int i, int j, int[][] boards) {
        int live = 0;
        for (int k = 0; k < 8; k++) {
            int x = i + deltaX[k];
            int y = j + deltaY[k];
            if (!inBound(x, y)) {
                continue;
            }
            if ((boards[x][y] & 1) == 1) {
                live++;
            }
                    
        }
        return live;
    }
    public boolean inBound(int x, int y) {
        return x < m && y < n && x >= 0 && y >= 0;
    }
}
