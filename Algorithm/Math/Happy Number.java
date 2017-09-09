for the sum of two numbers square, there are only two conditions:
one is sum = 1 , another is infinite loop, and the total set of the sum of two numbers square is limited. so we can use a hashset to 
test whether the number is already inside an infinite loop or not.
class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        while (sum != 1) {
            sum = 0;
            while (n != 0) {
                int s = n % 10;
                sum += Math.pow(s, 2);
                n /= 10;
            }
            if (set.contains(sum)) return false;
            set.add(sum);
            n = sum;
        }
        return true;
    }
}
