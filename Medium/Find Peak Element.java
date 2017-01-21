class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            // upward
            if (A[mid] > A[mid - 1] && A[mid + 1] > A[mid]) {
                //right hand side must have a peak
                start = mid;
            // downward
            } else if (A[mid] < A[mid - 1] && A[mid + 1] < A[mid]) {
                end = mid;
            } else if (A[mid] < A[mid - 1] && A[mid] < A[mid + 1]) {
                end = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
