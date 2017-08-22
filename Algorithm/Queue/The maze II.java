1. although it is processed level by level, but the first time it arrives at the destination does not mean the shortest distance,
hence it is logical for us to track a min distance map;
2. we cannot directly return when we first meet the destination point
class Solution {
    int m;
    int n;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0] == null || maze[0].length == 0) {
            return -1;
        }
        m = maze.length;
        n = maze[0].length;
        int[][] minDistance = new int[m][n];
        for (int i = 0; i < m ; i++)
            Arrays.fill(minDistance[i], Integer.MAX_VALUE);
        bfs(maze, start, destination, minDistance);
        return minDistance[destination[0]][destination[1]] == Integer.MAX_VALUE ? - 1 : minDistance[destination[0]][destination[1]];
  }
    public void bfs(int[][] maze, int[] start, int[] destination, int[][] minDistance) {
        Queue<int[]> queue = new LinkedList<>();
        //coordinate and the distance...
        queue.offer(new int[] {start[0], start[1]});
        minDistance[start[0]][start[1]] = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] s = queue.poll();
             //   if (s[0] == destination[0] && s[1] == destination[1])   return;
                for (int j = 0; j < 4; j++) {
                    int x = s[0] + dx[j];
                    int y = s[1] + dy[j];
                    int step = 0;
                    while (canGo(x, y, maze)) {
                        step++;
                        x += dx[j];
                        y += dy[j];
                    }
                    if (minDistance[s[0]][s[1]] + step < minDistance[x - dx[j]][y - dy[j]]) {
                        minDistance[x - dx[j]][y - dy[j]] = minDistance[s[0]][s[1]] + step;
                        queue.offer(new int[]{x - dx[j], y - dy[j]});
                    }
                }
            }
            
        }
    }
    public boolean canGo(int x, int y, int[][] maze) {
        return x >= 0 && y >= 0 && x < m && y < n && maze[x][y] == 0;
    }
}
