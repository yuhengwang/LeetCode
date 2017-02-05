/**
 * Definition for a point.
 * public class Point {
 *     publoc int x, y;
 *     public Point() { x = 0; y = 0; }
 *     public Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    int n, m; // size of the chessboard
    int[] deltaX = {1, 1, 2, 2, -1, -1, -2, -2};
    int[] deltaY = {2, -2, 1, -1, 2, -2, 1, -1};
    /**
     * @param grid a chessboard included 0 (false) and 1 (true)
     * @param source, destination a point
     * @return the shortest path 
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // Write your code here
        if (grid == null || grid[0].length == 0 || source == null || destination == null) {
            return 0;
        }
        n = grid.length;
        m = grid[0].length;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);
        int num = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();  // divide layers...
            for (int j = 0; j < size; j++) {
                Point current = queue.poll();
              //  System.out.println(current.x + " " + current.y);
                if (current.x == destination.x && current.y == destination.y) {
                return num;
                }
            
                for (int i = 0; i < 8; i++) {
                    int x = current.x + deltaX[i];
                    int y = current.y + deltaY[i];
                    if (inBound(x, y)) {
                   //      System.out.println("x,y: " + x + " " + y);
                        if (grid[x][y] == false) {// 0 empty
                            Point point = new Point(x, y);
                            queue.offer(point);
                            grid[x][y] = true;
                        }
                    } else {
                        continue;
                    }
                }
            }
              num++;
        }
        return -1;
        
    }
    public boolean inBound(int x, int y) {
        if (x < n && y < m && x >= 0 && y >= 0) {
            return true;
        } else {
            return false;
        }
    }
}
