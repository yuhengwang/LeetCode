//we only need to find function in unionfind class. 
if the nodes on the edge share the same parents, it means it is graph instead of a tree
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
    public int find(int i, int[] island) {
        if (island[i] == -1)    return i;
        return island[i] = find(island[i], island);
    }
}
