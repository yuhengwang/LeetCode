public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        if (A == null || A.length == 0) {
            return false;
        }
        //state: whether we can jump here or not
        boolean[] jump = new boolean[A.length];
        //initialize
        jump[0] = true;
        //loop
        for (int i = 0; i < A.length; i++) {
            if (A[i] != 0 && jump[i]) {
                int t = A[i];
                while (t > 0) {
                    jump[Math.min(i + t, A.length - 1)] = true;
                    t--;
                }
            }
        }
        //answer
        return jump[A.length - 1]; 
    }
}
