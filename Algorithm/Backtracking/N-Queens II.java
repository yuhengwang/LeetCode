//only return the total number of viable solutions. The key point is in the chessboard, 45 degree, the position of each square row - col are same,
//135 degree, the position of each sqaure row + col are same. we can also use array of boolean to replace the hashset to increase the speed.
boolean[] column = new boolean[n]; boolean[] diag = new boolean[2 * n]; boolean[] antiDia = new boolean[2 * n];
public class Solution {
    int count;
    HashSet<Integer>column = new HashSet<>();
    HashSet<Integer> diag = new HashSet<>();
    HashSet<Integer> antiDiag = new HashSet<>();
    public int totalNQueens(int n) {
        count = 0;
        totalNQueensHelper(n, 0);
        return count;
    }
    public void totalNQueensHelper(int n, int row) {
        for (int col = 0; col < n; col++) {
            if (column.contains(col)) continue;
            if (diag.contains(row - col)) continue;
            if (antiDiag.contains(row + col)) continue;
            if (row == n - 1) count++;
            else {
                column.add(col);
                diag.add(row - col);
                antiDiag.add(row + col);
                totalNQueensHelper(n, row + 1);
                column.remove(col);
                diag.remove(row - col);
                antiDiag.remove(row + col);
            }
        }
    }
}
