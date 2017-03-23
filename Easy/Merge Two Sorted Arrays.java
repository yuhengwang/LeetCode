class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // Write your code here
        if ((A == null && B == null) || (A.length == 0 && B.length == 0)) {
            return new int[]{};
        }
        int i = 0;
        int j = 0;
        int[] result = new int[A.length + B.length];
        int index = 0;
        while (i < A.length && j < B.length) {
            if (A[i] < B[j]) {
                result[index++] = A[i];
                i++;
            } else{
                result[index++] = B[j];
                j++;
            }
        }
        while (i < A.length) {
            result[index++] = A[i++];
        }
        while (j < B.length) {
            result[index++] = B[j++];
           // System.out.println(j);
        }
        return result;

    }
    }
