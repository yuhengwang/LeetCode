// because the specialty of sudoku, 
// checking for each 3x3 block from left to right, from up to down
//boolean add(E e) 
Adds the specified element to this set if it is not already present. 

public class Solution {
    public boolean isValidSudoku(char[][] board) {
         for (int i = 0; i < 9; i++) {
             HashSet<Character> rows = new HashSet<>();
             HashSet<Character> columns = new HashSet<>();
             HashSet<Character> cubes = new HashSet<>();
             for (int j = 0; j < 9; j++) {
                 if (board[i][j] != '.' && !rows.add(board[i][j])) return false;
                 if (board[j][i] != '.' && !columns.add(board[j][i])) return false;
                 //when i = 0, checking the first cube: 0,0;;0,1;0,2;,1,0,1,1.....
                 // when i = 1, checking the second cube, 0, 3;0, 4;0, 5.....
                 if (board[3 * (i / 3) + j /3][3 * (i % 3) + j % 3] != '.' && !cubes.add(board[3 * (i / 3) + j /3][3 * (i % 3) + j % 3]))
                     return false;
             }
         }
        return true;
    }
}
