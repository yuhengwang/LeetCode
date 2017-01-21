public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if (A.length == 0 || A == null) {
            return -1;
        }
        int start = 0;
        int end = A.length - 1;
        int left = A[0];
        int right = A[end];
        // need to identify whether target is at right or left
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (A[mid] == target) {
                start = mid;
            }
            if (A[mid] > target && target >= left) {
                end= mid; 
            } else if (A[mid] > target && target <= right && A[mid] > left) {  // mid is at left
                start = mid;
            } else if (A[mid] > target && target <= right && A[mid] < right) {  // mid is at right
                end = mid;
            } else if (A[mid] < target && target >= left && A[mid] > left) {  // mid is at left
                start = mid;
            } else if (A[mid] < target && target >= left && A[mid] < right) {   // mid is at right
                end = mid;
            } else {
                start = mid;
            }
        }
        if (A[start] == target) {
            return start;
        }
        if (A[end] == target) {
            return end;
        }
        return -1;
    }
}
