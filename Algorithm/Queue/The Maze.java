// the ball won't stop until hit the wall, which mean it will continuously move in same direction, it cannot change 
its direction in the mid way. Difference!!
space complexity mn, time : mn
class Solution {
    int m;
    int n;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        //the destination has 3 block nearby
        if (maze == null || maze.length == 0 || maze[0] == null || maze[0].length == 0) return false;
        m = maze.length;
        n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        return bfs(maze, start, destination, visited);
    }
    private boolean bfs(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1]}); //start position, no last step movement
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0;i < size; i++) {
                int[] s = queue.poll();
                if (s[0] == destination[0] && s[1] == destination[1]) return true;
                for (int j = 0; j < 4; j++) {
                    int x = s[0] + dx[j];
                    int y = s[1] + dy[j];
                    while (canGo(x, y, maze))  {
                        x += dx[j];
                        y += dy[j];
                    }
                    //update visited
                    while (!visited[x - dx[j]][y - dy[j]]) {
                    queue.offer(new int[]{x - dx[j], y - dy[j]});
                    visited[x - dx[j]][y - dy[j]] = true;
                    }
                }
            }
        }
        return false;
    }
    private boolean canGo(int x, int y, int[][] maze) {
        return x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0;
    }
}
