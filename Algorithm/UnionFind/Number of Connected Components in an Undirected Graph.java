最经典的unionfind问题。

class Solution {
    class UnionFind {
        int[] father = null;
        int count;
        UnionFind(int n) {
            count = n;
            father = new int[n];
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
        }
        public int find(int i) {
            if (father[i] == i) return i;
            return father[i] = find(father[i]);
        }
        public void connect(int a, int b) {
            int root_a = find(a);
            int root_b = find(b);
            if (root_a != root_b) {
                father[root_a] = root_b;
                count--;
            }
        }
        public int query() {
            return count;
        }
    }
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] e : edges) {
            uf.connect(e[0], e[1]);
        }
        return uf.query();
    }
}
