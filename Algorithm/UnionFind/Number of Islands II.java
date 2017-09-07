//require the time complexity as Klog(m * n).
for each added island, we update the father array, and we check the island surroundded region, if there is an island and we check the father of 
that island, if these two are different, we merge them rogether and reduce the count by 1.
MOST IMPORTANT!!!!
union find is only union the big father, after the union, we need to update the big father!!!!!!
class Solution {
    int[][] dir = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    public int find(int i, int[] father) {
        if (father[i] == i) return i;
        return father[i] = find(father[i], father);
    }
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        int count = 0;
        int[] father = new int[n * m];
        Arrays.fill(father, -1);
        for (int[] p: positions) {
            int island = p[0] * n + p[1];
            count++;
            father[island] =island;
            for (int[] d : dir) {
                int x = p[0] + d[0];
                int y = p[1] + d[1];
                if (x < 0 || x >= m || y < 0 || y >= n || father[x * n + y] == -1)  continue;
                int nb = x * n + y;
                int r = find(nb, father);
                if (island != r) {
                    father[island] = r;
                    //UPDATE BIG FATHER!!!!!!!!
                    island = r;
                    count--;
                }
            }
            result.add(count);
        }
        return result;
    }
}
