this question we need to track the length and path information, so we all include them into class Point, and use priorityqueue to find
the shortest and lexigraphically small path string. no matter the ball drop into hole or just hit the wall, we will put into queue anyways,
but we will not update the point m x n map, if we already have better solution
class Solution {
    class Point implements Comparable<Point>{
        int x;
        int y;
        String path;
        int length;
        public Point (int x, int y, String path, int length) {
            this.x = x;
            this.y = y;
            this.path = path;
            this.length = length;
        }
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            path = "";
            length = Integer.MAX_VALUE;
        }
        public int compareTo(Point p) {
            return length == p.length ? path.compareTo(p.path) : length - p.length;
        }
    }
  
    int m;
    int n;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        if (maze == null || maze.length == 0 || maze[0] == null || maze[0].length == 0) 
            return "impossible";
        m = maze.length;
        n = maze[0].length;
        Point[][] point = new Point[m][n];
        for (int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                point[i][j] = new Point(i, j);
        bfs(maze, ball, hole, point);
        return point[hole[0]][hole[1]].length == Integer.MAX_VALUE ? "impossible" : point[hole[0]][hole[1]].path;         
    }
    public void bfs(int[][] maze, int[] ball, int[] hole, Point[][] point) {
        PriorityQueue<Point> queue = new PriorityQueue<>();
        Point start = new Point(ball[0], ball[1], "", 0);
        queue.offer(start);
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (point[p.x][p.y].compareTo(p) <= 0)   continue;
                point[p.x][p.y] = p;
            //p.x and p.y can be the hole, hence int x and int y should test the hole situation first without adding direction movement
            for (int j = 0; j < 4; j++) {
                int x = p.x;
                int y = p.y;
                int route = p.length;
                while (canGo(x, y, maze) && !(x == hole[0] && y == hole[1])) {
                    x += dx[j];
                    y += dy[j];
                    route++;
                }
                if (!(x == hole[0] && y == hole[1])) {
                    route--;
                    x -= dx[j];
                    y -= dy[j];
                } 
                queue.offer(new Point(x, y, p.path + getPath(j + 1), route));
            }
            
        }
    }
    public String getPath(int n) {
        if (n == 1) return "u";
        if (n == 2) return "r";
        if (n == 3) return "d";
        if (n == 4) return "l";
        return "";
    }
    public boolean canGo(int x, int y, int[][] maze) {
        return x >= 0 && y >= 0 && x < m && y < n && maze[x][y] == 0;
    }
}
