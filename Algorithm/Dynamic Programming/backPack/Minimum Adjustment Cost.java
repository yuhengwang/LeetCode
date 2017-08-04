public class Solution {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        int n = A.size();
    //f[i][v]: 前i个数，第i个数调整为v，满足相邻两数<=target，所需要的最小代价
        int[][] f = new int[n + 1][101];
        //initialization
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= 100; j++) {
                f[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int j = 0; j <= 100; j++) {
            f[0][j] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 100; j++) {
                if (f[i - 1][j] != Integer.MAX_VALUE) {// the previous part need to be viable
                    for (int k = 0; k <= 100; k++) {
                        if (Math.abs(j - k) <= target) { //adjacent number different cannot be larger than target
                            f[i][k] = Math.min(f[i][k],
                            f[i - 1][j] + Math.abs(A.get(i - 1) - k));
                        }
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 100; i >= 0; i--) {
            ans = Math.min(ans, f[n][i]);
        }
        return ans;
    }
}
