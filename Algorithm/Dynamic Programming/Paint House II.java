class Solution {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0] == null || costs[0].length == 0) {
            return 0;
        }
        int m = costs.length;
        int n = costs[0].length;
        int min1 = -1; //which color can get the first smallest cost
        int min2 = -1; // which color can get the second smallest cost
        for (int i = 0; i < m; i++) {
            int last1 = min1, last2 = min2;
            min1 = -1;
            min2 = -1;
            for (int j = 0; j < n; j++) {
                if (j != last1) {
                    costs[i][j] += last1 < 0 ? 0 : costs[i - 1][last1];
                } else {
                    costs[i][j] += last2 < 0 ? 0 : costs[i - 1][last2];
                }
            if (min1 < 0 || costs[i][j] < costs[i][min1]) {
                min2 = min1;
                min1 = j;
            } else if (min2 < 0 || costs[i][j] < costs[i][min2]) {
                min2 = j;
            }
                
            }
            //update min1 and min2
          
        }
        return costs[m - 1][min1];
        
    }
}
