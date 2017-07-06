//leetcode 42
// we use 2 pointer to first check the leftmost and rightmost barrier to contain the water.
// to deal with 4 2 3, situation, we need to compare the height of leftmost and rightmost to decide how much water is trapped.
// if we encounter a height smaller than the left/rightmost height, we can add the difference of the height to the total amount of water trapped

public class Solution {
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int l = 0;
        int r = height.length - 1;
        //find the leftmost and rightmost edge to contain the water
        while (l < r && height[l] < height[l + 1]) {
            l++;
        }
        while (l < r && height[r] < height[r - 1]) {
            r--;
        }
        int res = 0;
        while (l < r) {
            int left = height[l];
            int right = height[r];
            if (left < right) {
                while (l < r && height[++l] < left) {
                    res += (left - height[l]);
                }
            } else {
                while (l < r && height[--r] < right) {
                    res += (right - height[r]);
                }
            }
        }
        return res;
        
    }
}
