class Solution {
    public boolean isPerfectSquare(int num) {
        num = Math.abs(num);
        int start = 1;
        int end = num;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (num % mid == 0 && mid == num / mid) {
                return true;
            } else if (mid < num / mid) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if ((start == num / start && num % start == 0) || (num % end == 0 && end == num / end)) {
            return true;
        }
        return false;
    }
}
