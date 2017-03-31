/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param n an integer
     * @param m an integer
     * @param operators an array of point
     * @return an integer array
     */
    int[] deltaX = {-1, 0 , 0, 1};
    int[] deltaY = {0, 1, -1, 0};
    class UnionFind {
        private int[] father = null;
        UnionFind(int n) {
            father = new int[n];
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
        }
        public int compressedFind(int x) {
            int parent = father[x];
            while (parent != father[parent]) {
                parent = father[parent];
            }
            int fa = x;
            int temp = -1;
            while (fa != father[fa]) {
                temp = father[fa];
                father[temp] = parent;
                fa = temp;
            }
            return parent;
        }
        public void union(int x, int y) {
            int fa_x = compressedFind(x);
            int fa_y = compressedFind(y);
            if (fa_x != fa_y) {
                father[fa_x] = fa_y;
            }
        }
    }
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // Write your code here
        if (operators == null || operators.length == 0) {
            return new ArrayList<Integer>();
        }
        List<Integer> res = new ArrayList<>();
        int count = 0;
        int[][] island = new int[n][m];
        UnionFind uf = new UnionFind(n * m);
        for (Point operator : operators) {
          
            if (island[operator.x][operator.y] != 1) {
                  count++;
            island[operator.x][operator.y] = 1;
            for (int i = 0; i < 4; i++) {
                int x = operator.x + deltaX[i];
                int y = operator.y + deltaY[i];
                if (!inBound(n, m, x, y)) {
                    continue;
                }
                if (island[x][y] == 1) {
                    if (uf.compressedFind(x * m + y) != uf.compressedFind(m * operator.x + operator.y)) {
                        uf.union(m * operator.x + operator.y, m * x + y);
                        count--;
                    }
                }
            }
        }
           res.add(count);
        }
        return res;
        
    }
    public boolean inBound(int n, int m, int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < m);
    }
}
