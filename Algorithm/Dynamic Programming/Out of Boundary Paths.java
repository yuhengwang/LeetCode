//leetcode 576
the state is int[][] count, representing how many paths to arrive at this position. Because for ith step, we only see the i-1 step situation. 
before the first step, which is 0th step, int[][] count should be all zeros except for the starting point. that is the reason we put count[i][j] = 1;
and for the first step. The template for the count for each following step must be zero, after using the previous count information, it will be updated.
e.g.
2
2
2
0
0

output of count after 1st step
0 1 
1 0 

putput of count after 2nd step
2 0 
0 2 

public class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        int mod = 1000000007;
        int[][] count = new int[m][n];
        count[i][j] = 1;
        int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        int result = 0;
        for (int step = 0; step < N; step++) {
            int[][] temp = new int[m][n];
            for (int k = 0; k < m; k++) {
                for (int q = 0; q < n; q++) {
                    for (int[] d : directions) {
                        int nk = k + d[0];
                        int nq = q + d[1];
                        if (nk < 0 || nk >= m || nq < 0 || nq >= n) {
                            result = (result + count[k][q]) % mod;
                        } else {
                            temp[nk][nq] = (temp[nk][nq] + count[k][q]) % mod;
                        }
                    }
                }
            }
            count = temp;
        }
        return result % mod;
    }
}
