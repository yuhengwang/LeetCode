public class Solution {
    /**
     * @param grid a 2D grid
     * @return an integer
     */
    public int shortestDistance(int[][] grid) {
        // Write your code here
        int n = grid.length;
        if (n == 0) {
            return -1;
        }
        int m = grid[0].length;
        if (m == 0) {
            return -1;
        }
        List<Integer> sumx = new ArrayList<>();
        List<Integer> sumy = new ArrayList<>();
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    x.add(i);
                    y.add(j);
                }
            }
        }
        Collections.sort(x);
        Collections.sort(y);
        int size = x.size();
        int result = Integer.MAX_VALUE;
        sumx.add(0);
        sumy.add(0);
        for (int i = 1; i <= size; i++) {
            sumx.add(sumx.get(i - 1) + x.get(i - 1));
            sumy.add(sumy.get(i - 1) + y.get(i - 1));
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    int cost_x = costFunction(x, sumx, i, size);
                    int cost_y = costFunction(y, sumy, j, size);
                    if (cost_x + cost_y < result) {
                        result = cost_x + cost_y;
                    }
                }
            }
        }
        return result;
        
    }
    public int costFunction(List<Integer> x, List<Integer> sum, int pos, int n) {
        if (n == 0) {
            return 0;
        }
        if (x.get(0) > pos) {
            return sum.get(n) - pos * n;
        }
        int l = 0;
        int r = n - 1;
        while (l + 1 < r) {
            int mid = (r - l) / 2 + l;
            if (x.get(mid) > pos) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        int index = 0;
        if (x.get(r) <= pos) {
            index = r;
        } else {
            index = l;
        }
        return pos * (index + 1) - sum.get(index + 1) + sum.get(n) - sum.get(index + 1) - pos * (n - index - 1);
    }
}
