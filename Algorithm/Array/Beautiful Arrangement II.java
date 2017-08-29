如果只有一个diff,就按顺序拍
否则
i++, j--,剩下的看下是i++还是j--合适，使得后面的数差均为1
class Solution {
    public int[] constructArray(int n, int k) {
        //difference k , k - 1,... 1
        int[] res = new int[n];
        if (k == 1) {
            for (int i = 1; i <= n; i++) {
                res[i - 1] = i;
            }
            return res;
        }
        int i = 1;
        int j = n;
        int index = 0;
        while (index < k) {
            res[index++] = i++;
            if (index < k)
                res[index++] = j--;
        }
        
        if (res[index - 1] == j + 1) {
            while (index < n)
                res[index++] = j--;
        } else {
            while (index < n)
                res[index++] = i++;
        }
        return res;
    }
}
