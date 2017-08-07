//divide and conquer, logn time complexity
public class Solution {
    public double myPow(double x, int n) {
        if (x == 1.0 || x == -1.0) {
            return n % 2 == 0 ? Math.abs(x) : x;
        }
        if (n == Integer.MIN_VALUE || n == Integer.MAX_VALUE) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}
