^ is XOR in bit operation, different bit results in 1, same bit results in 0
public class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
