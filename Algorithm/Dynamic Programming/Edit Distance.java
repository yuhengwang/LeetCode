//space complexity O(m)
public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
  
        int[] f = new int[m + 1];
        //initialization
        for (int i = 0; i <= m; i++) {
            f[i] = i;
        }
        for (int j = 1; j <= n; j++) {
            int pre = f[0];
            f[0] = j;
            for (int i = 1; i <= m; i++) {
                int temp = f[i];
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    f[i] = pre;
                } else {
                    f[i] = Math.min(pre + 1, Math.min(f[i - 1] + 1, f[i] + 1)); //f[i - 1] to change to word2.(0, j - 1)
                                                                    //f[i] to change to word2.(0, j -1)
                }
                pre = temp;
            }
        }
        return f[m];
        
    }
}

// the space complexity can be optimized from m * n to m because it only depends on last row and current row
public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // how many steps to convert word1.substring(0, i) to word2.substring(0, j)
    
        int[][] f = new int[m + 1][n + 1];
        //initialization
        for (int i = 0; i <= m; i++) {
            f[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            f[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1];
                } else
                    f[i][j] = Math.min(f[i - 1][j], Math.min(f[i][j - 1], f[i - 1][j - 1])) + 1;
            }
        }
        return f[m][n];
        
    }
}
