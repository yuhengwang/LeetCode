//leetcode 605
u
public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < flowerbed.length && count < n; i++) {
            if (flowerbed[i] == 0) {
                int next = i == flowerbed.length - 1 ? 0 : flowerbed[i + 1];
                int prev = i == 0 ? 0 : flowerbed[i - 1];
                if (prev == 0 && next == 0) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        return n == count;
    }
}
