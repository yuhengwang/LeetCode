public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return;
        }
       // for (int i = A.length / 2; i >= 0; i--)
        //    siftdown(A, i);
        for (int i = 0; i < A.length; i++) {
            siftup(A, i);
        }
    }
    private void siftdown(int[] A, int i) {
        // check whether their children is higher than them, find the smallest one from parents and two children
        while (i < A.length) {
            int smallest = i;
            if (i * 2 + 1 < A.length && A[smallest] > A[i * 2 + 1]) {
                smallest = i * 2 + 1;
            }
            if (i * 2 + 2 < A.length && A[smallest] > A[i * 2 + 2]) {
                smallest = i * 2 + 2;
            }
            if (smallest == i) {
                break;
            }
         //   System.out.println(i + "\t" + smallest);
            int temp = A[i];
            A[i] = A[smallest];
            A[smallest] = temp;
            i = smallest;
        }
        
    }
    private void siftup(int[] A, int i) {
        // check whether it is larger than its parents
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (A[i] > A[parent]) {
                break;
            }
            if (parent >= 0 && A[parent] >= A[i]) {
                int temp = A[parent];
                A[parent] = A[i];
                A[i] = temp;
            }
            i = parent;
            
        }
    }
}
