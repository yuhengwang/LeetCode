public class Solution {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if (L == null || L.length == 0) {
            return 0;
        }
        int start = 1;
        int end = 0;
        for (int i = 0; i < L.length; i++) {
            end = Math.max(end, L[i]) == end ? end : L[i];
        }
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (numberOfCut(mid, L) == k) {
                start = mid;
            } else if (numberOfCut(mid, L) < k) {
                end = mid;
            } else {
                start = mid;
            }
        }
        //double check
        if (numberOfCut(end, L) >= k) {
            return end;
        }
        if (numberOfCut(start, L) >= k) {
            return start;
        }
        return 0;
    }
    public int numberOfCut(int length, int [] L) {
        int num = 0;
        for (int i = 0; i < L.length; i++) {
            num += L[i] / length;
        }
        return num;
    }
}
