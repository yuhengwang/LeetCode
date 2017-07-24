//n 相当于数字的位数，但是 
public class Solution {
    int count = 0;
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        boolean[] used = new boolean[10]; //0 - 9
        for (int i = 1; i <= n; i++) {
            dfs(i, used, "");
        }
        return count;
    }
    public void dfs(int place, boolean[] used, String digit) {
        if (digit.length() > place) {
            return;
        }
        if (digit.length() == place) {
            count++;
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (digit.length() == 0 && i == 0 && place > 1) {
                continue;
            }
            if (used[i]) {
                continue;
            }
            used[i] = true;
            dfs(place, used, digit + i);
            digit = digit.substring(0, digit.length());
            used[i] = false;
        }
    }
}
