class Solution {
    public boolean isPowerOfThree(int n) {
        //Math.round +0.5, floor.
          return n==0 ? false : n==Math.pow(3, Math.round(Math.log(n) / Math.log(3)));
    }
}
