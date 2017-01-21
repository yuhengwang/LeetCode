class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        //start 1, end x
        if(x == 0) {
            return 0;
        }
        int start = 1;
        int end = x;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (x / mid == mid) {
                start = mid;
            } else if (x / mid < mid) {
                end = mid;
            } else {
                start = mid;
            }  
        }
        return Math.min(start * start - x, end * end - x) == start * start - x ? start : end;
    }
}
