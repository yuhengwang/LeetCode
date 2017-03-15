// time limit exceed
class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        int count = 0;
        int pl = 0;
        int ph = colors.length - 1;
        while (count < k) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = pl; i <= ph; i++) {
                min = Math.min(min, colors[i]);
                max = Math.max(max, colors[i]);
            }
           // System.out.println(min);
            int left = pl;
            int right = ph;
            int current = left;
            while (current <= right) {
                if (colors[current] == min) {
                    swap(colors, current, left);
                    left++;
                    current++;
                } else if (colors[current] == max) {
                    swap(colors, current, right);
                    right--;
                } else {
                    current++;
                }
            }
            count += 2;
            pl = left;
            ph = right;
            
        }
        
    }
    public void swap(int[] colors, int i, int j) {
        int temp = colors[i];
        colors[i] = colors[j];
        colors[j] = temp;
    }
}
//rainbow sort
class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        if (colors == null || colors.length == 0 || k < 0) {
            return;
        }
        rainbowSort(colors, 0, colors.length - 1, 1, k);
    }
    public void rainbowSort(int[] colors, int left, int right, int colorFrom, int colorTo) {
        if (left >= right) {
            return;
        }
        if (colorFrom >= colorTo) {
            return;
        }
        int l = left;
        int r = right;
        int colorMid = (colorTo + colorFrom) / 2;
        while (l < r) {
            while (l < r && colors[l] <= colorMid) {
                l++;
            }
            while (l < r && colors[r] > colorMid) {
                r--;
            }
            if (l < r) {
            int temp = colors[r];
            colors[r] = colors[l];
            colors[l] = temp;
            l++;
            r--;
            }
        }
        rainbowSort(colors, left, r, colorFrom, colorMid);
        rainbowSort(colors, l, right, colorMid + 1, colorTo);
    }
}
