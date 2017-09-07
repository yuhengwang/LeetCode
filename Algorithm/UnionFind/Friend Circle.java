//exactly sames as the connected undirected graph.
class Solution {
    class UnionFind {
	private int[] father = null;
	private int count;
	
	//similar to compressed_find
	private int find(int x) {
		if (father[x] == x) {
			return x;
		}
		return father[x] = find(father[x]);
	}
	
	public UnionFind(int n) {
		father = new int[n];
        count = n;
		for (int i = 0; i < n; i++)
			father[i] = i;
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
    public int findCircleNum(int[][] M) {
        UnionFind uf = new UnionFind(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                if (M[i][j] == 1) {
                    uf.connect(i, j);
                }
            }
        }
        return uf.query();
    }
   
}
