//first notice:
only the O which is connected to the boundary do not need to be changed, other O need to be change to X.
we can connect the boundary O to another dummy node, which is n * m in this case. And after the traverse,
we will go through each 'O', if it do not share the same parent with n * m, we will change it to 'X'
class Solution {
    class UnionFind {
        int[] father = null;
        int count;
        UnionFind(int n) {
            father = new int[n];
            count = n;
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
                count--;
                father[root_a] = root_b;
            }
        }
        public int query() {
            return count;
        }
    }
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        UnionFind uf = new UnionFind(n * m + 1);
        //have one dummy node in the end
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
             //   System.out.println(i + " " + j);
                if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) &&board[i][j] == 'O') {
                    uf.connect(i * n + j, n * m);
                } else if (board[i][j] == 'O') {
                    if (board[i - 1][j] == 'O') uf.connect((i - 1) * n + j, i * n + j);
                    if (board[i][j - 1] == 'O') uf.connect(i * n + (j - 1), i * n + j);
                    if (board[i + 1][j] == 'O') uf.connect((i + 1) * n + j, i * n + j);
                    if (board[i][j + 1] == 'O') uf.connect(i * n + j, i * n + j + 1);
                }
                
            }
        }
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if (uf.find(i * n + j) != uf.find(m * n)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
