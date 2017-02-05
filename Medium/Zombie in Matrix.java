public class Solution {
    /**
     * @param grid  a 2D integer grid
     * @return an integer
     */
    int [] deltaX = {1, 0, 0, -1};
    int [] deltaY = {0, 1, -1, 0};
    int WALL = 2;
    int ZOMBIE = 1;
    int PEOPLE = 0;
    int n;
    int m;
    class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int zombie(int[][] grid) {
        // Write your code here
        if (grid == null || grid[0].length == 0) {
            return 0;
        }
        n = grid.length;
        m = grid[0].length;
        Queue<Point> queue = new LinkedList<>();
        int people = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == ZOMBIE) {
                    queue.offer(new Point(i, j));
                }
                if (grid[i][j] == PEOPLE) {
                    people++;
                }
            }
        }
      //  System.out.println(people);
        int num = 0;
        int newZombie = 0;
        while(!queue.isEmpty()) {
            num++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                  Point current = queue.poll();
                  for (int j = 0; j < 4; j++) {
                      Point point = new Point(current.x + deltaX[j], current.y + deltaY[j]);
                      if (validPath(point, grid)) {
                          newZombie++;
                          if (newZombie == people) {  // when achieve the requirement, stop adding to the queue
                              return num;
                          }
                          queue.offer(point);
                          grid[point.x][point.y] = ZOMBIE;
                      } else {
                    //      System.out.println(point.x + " " + point.y);
                          continue;
                      }
                      
                    }
            
            }
         
        }
      //  System.out.println(newZombie);
        if (newZombie != people) {
            return -1;
        } else {
            return num;
        }
        
        
    }
    public boolean validPath (Point current, int [][] grid) {
        if (current.x < 0 || current.x >= n) {
            return false;
        }
        if (current.y < 0 || current.y >= m) {
            return false;
        }
        return grid[current.x][current.y] == PEOPLE;
    }
}
