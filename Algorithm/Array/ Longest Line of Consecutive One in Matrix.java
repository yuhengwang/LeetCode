// brute force solution, better solution investgating.......
public class Solution {
    int longest = 0;
    int m;
    int n;
    public int longestLine(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }
        m = M.length;
        n = M[0].length;
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                if (M[i][j] == 1) {
                    caculate(M, i, j);
                }
            }
        }
        return longest;
        
    }
    //right, down, and rightdown 45
    public void caculate(int[][] M,  int i, int j) {
        //right
        int right = caculateRight(M, i, j);
        int down = caculateDown(M, i, j);
        int dia = caculateDiag(M, i, j);
   //     System.out.println(right + "\t" + down + "\t" + dia);
        longest = Math.max(Math.max(right, longest), Math.max(down, dia));
        
    }
    public int caculateRight(int[][] M, int i, int j) {
         int sum = 0;
        while (j < n) {
            if (M[i][j] == 1) {
                sum++;
            } else {
                break;
            }
            j++;
        }
        return sum;
    }
     public int caculateDown(int[][] M, int i, int j) {
        int sum = 0;
        while (i < m) {
            if (M[i][j] == 1) {
                sum++;
            } else {
                break;
            }
            i++;
        }
        return sum;
    }
    public int caculateDiag(int[][] M, int i, int j) {
        int sum = 0;
        int tempi = i;
        int tempj = j;
        while (i < m && j < n) {
            if (M[i][j] == 1) {
                sum++;
            } else {
                break;
            }
            i++;
            j++;
        }
        longest = Math.max(longest, sum);
        sum = 0;
        i = tempi;
        j = tempj;
        while (i < m && j >= 0) {
            if (M[i][j] == 1) {
                sum++;
            } else {
                break;
            }
            i++;
            j--;
        }
        longest = Math.max(longest, sum);
        sum = 0;
        i = tempi;
        j = tempj;
        while (i >= 0 && j >= 0) {
            if (M[i][j] == 1) {
                sum++;
            } else {
                break;
            }
            i--;
            j--;
        }
        longest = Math.max(longest, sum);
        sum = 0;
        i = tempi;
        j = tempj;
        while (i >= 0 && j < n) {
            if (M[i][j] == 1) {
                sum++;
            } else {
                break;
            }
            i--;
            j++;
        }
        longest = Math.max(longest, sum);
        return sum;
    }
}
