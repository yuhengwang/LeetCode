// similar to number of island, we use boolean array to connect the friend circle

public class Solution {
    int circle = 0;
    public int findCircleNum(int[][] M) {
        if (M == null || M[0] == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }
        boolean[] visited = new boolean[M.length];
        for (int i = 0; i < M.length; i++) {
          if (!visited[i]) {
              visited[i] = true;
              dfs(M, i, visited); //connect same friend circle
              circle++;
          }
        }
        return circle;   
    }
   
    public void dfs(int[][] M, int i, boolean[] visited) {
       for (int j = 0; j < M[i].length; j++) {
           if (!visited[j] && M[i][j] == 1) {
               visited[j] = true;
               dfs(M, j, visited);
           }
       }
    }
}

