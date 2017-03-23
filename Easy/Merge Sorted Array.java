class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int i = 0;
        int j = 0;
        while (i < m + n && j < B.length) {
            if (i < m + n - 1 && B[j] >= A[i] && B[j] <= A[i + 1]) {
                insertInto(A, B[j], i + 1, m);
                m++;
                n--;
                j++;
                i++;
            } else if (B[j] < A[i]) {
                if (i == 0) {
                    insertInto(A, B[j], i, m);
                    m++;
                    n--;
                    j++;
                } 
            } else {
              //  System.out.println(i);
                //System.out.println(B[j]);
                if (i == m) {
                    insertInto(A, B[j], i, m);
                    m++;
                    n--;
                    j++;
                    i++;
                } else {
                    i++;
                }
            }
        }
    }
    public void insertInto(int[] A, int num, int index, int size) {
        while (size > index) {
            A[size] = A[--size];
        }
        A[size] = num;
    }
}
