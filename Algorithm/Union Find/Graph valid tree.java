class Solution {
    public boolean validTree(int n, int[][] edges) {
        //initialize n new island
        int[] island = new int[n];
        Arrays.fill(island, -1);
        for (int[] e : edges) {
            int x = find(e[0], island);
            int y = find(e[1], island);
            if (x == y) return false;
            island[x] = y;
        }
        return edges.length == n - 1;
    }
    //the parent island value is always -1, other part of the island are connected by nums[i]..
    public int find(int i, int[] island) {
        if (island[i] == -1)    return i;
        return find(island[i], island);
    }
}
