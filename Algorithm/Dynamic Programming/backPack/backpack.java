
public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int n = A.length;
        //state: 前i个物品能否组成和为S的数
        boolean[][] f = new boolean[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            f[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                //f[i][j] = f[i - 1][j]; 
                如果背包里还有足够的地方放i - 1th的物品，并且前i - 2个物品可以放进去
                if (A[i - 1] <= j && f[i - 1][j - A[i - 1]]) {
                    f[i][j] = true;
                } else {
                背包没有足够的地方，看前i -2个物品放进去的情况
                    f[i][j] = f[i - 1][j]; 
                }
            }
        }
        for (int i = m; i >= 0; i--) {
            if (f[n][i]) {
                return i;
            }
        }
        return 0;
    }
