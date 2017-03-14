class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int length = A.length + B.length;
        if (length % 2 == 1) {
            return findKth(A, 0, B, 0, length / 2 + 1);
        } else {
            return 0.5 * (findKth(A, 0, B, 0, length / 2) + findKth(A, 0, B, 0, length / 2 + 1));
        }
    }
    //find kth element after merging A and B
    public double findKth(int[] A, int A_start, int[] B, int B_start, int k) {
        if (A_start >= A.length) {
            return B[B_start + k - 1];
        }
        if (B_start >= B.length) {
            return A[A_start + k - 1];
        }
        if (k == 1) {
            return Math.min(A[A_start], B[B_start]);
        }
        int A_way = A_start + k / 2 - 1 < A.length ? A[A_start + k / 2 - 1] : Integer.MAX_VALUE;
        int B_way = B_start + k / 2 - 1 < B.length ? B[B_start + k / 2 - 1] : Integer.MAX_VALUE;
       // System.out.println(A_way + "\t" + B_way);
       
        if (A_way < B_way) {
            // throw k/2 element in A, hence we need to find k - k/2 th element in (thrown)A&B
            return findKth(A, A_start + k /2, B, B_start, k - k / 2);
        } else {
            return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
        }
    }
}
